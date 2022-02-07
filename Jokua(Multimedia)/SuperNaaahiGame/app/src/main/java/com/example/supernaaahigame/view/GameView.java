package com.example.supernaaahigame.view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;


import com.example.supernaaahigame.R;
import com.example.supernaaahigame.model.Background;
import com.example.supernaaahigame.model.Demonico;
import com.example.supernaaahigame.model.JimCarrey;
import com.example.supernaaahigame.model.Rodolfo;

import java.util.Random;

/**
 * Jokuaren elementu guztiak marrazten duen bista da
 */
public class GameView extends SurfaceView implements Runnable {

    public static float screenRatioX, screenRatioY;
    //public static float inputX, inputY, inputX1, inputY1;
    public static Paint paint = null, pu = null, pe = null, pt = null, score = null;
    private final Background background1, background2;
    public static final boolean debug = false;
    public static int screenX, screenY;
    private Thread thread;
    //private Random random;
    public static boolean isPlaying, isGameOver = false, isJump, isTocandoFondo, isBloqueao;
    public static Rodolfo rodolfo;
    public static Demonico demonico;
    public static JimCarrey carrey;
    private GameActivity activity;
    //private Bitmap pause;
    public static int tic = 0, backgroundSpeed = 5, backgroundSpeedRatio = 50;
    private Bitmap[] DemBitmap;
    private Bitmap[] CarreyBitmap;
    private Bitmap[] rodolfoBitmap;
    private static boolean orden;
    private static int c1 = 0;
    private static int c2 = 0;
    private int rodolfoSalto = 3500;
    private int rodolfoDepre = 4000;

    /**
     * GameView-ren konstruktorea
     *
     * @param activity
     * @param sX
     * @param sY
     */
    public GameView(GameActivity activity, int sX, int sY) {
        super(activity);

        // Atributo batzuk hasieratu
        isGameOver = false;
        rodolfo = null;
        tic = 0;
        backgroundSpeed = 10;
        Demonico.enemy1Speed = 25;
        JimCarrey.enemy2Speed = 25;

        // Oreinaren marrazkiak
        rodolfoBitmap = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.reno1),
                BitmapFactory.decodeResource(getResources(), R.drawable.reno2),
                BitmapFactory.decodeResource(getResources(), R.drawable.renoup),
                BitmapFactory.decodeResource(getResources(), R.drawable.renodown)
        };

        // Oreina objektua sortu
        rodolfo = new Rodolfo(rodolfoBitmap);

        // Marrazkiak eskalatu
        for (int i = 0; i < 4; i++) {
            rodolfoBitmap[i] = Bitmap.createScaledBitmap(rodolfoBitmap[i], rodolfo.width, rodolfo.height, false);
        }

        // Puntuak zerora jarri
        GameActivity.puntuak = 0;

        this.activity = activity;

        // Pantailaren width, height, screenRatioX eta screenRatioY zehaztu
        this.screenX = sX;
        this.screenY = sY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        // Fondo objekuak sortu eta jarri bigarren fondoaren x-a
        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());

        background2.x = screenX;

        // Debug-aren paint objektua sortu eta erabili
        paint = new Paint();
        pe = new Paint();
        pu = new Paint();
        pt = new Paint();
        score = new Paint();
        paint.setTextSize(128);
        paint.setColor(Color.BLACK);
        pe.setColor(Color.RED);
        pe.setStyle(Paint.Style.STROKE);
        pe.setStrokeWidth(5);
        pu.setColor(Color.BLUE);
        pu.setStyle(Paint.Style.STROKE);
        pu.setStrokeWidth(5);
        pt.setColor(Color.GREEN);
        pt.setStyle(Paint.Style.STROKE);
        pt.setStrokeWidth(2);
        score.setColor(Color.WHITE);
        score.setStyle(Paint.Style.FILL);
        score.setTextSize(80);

        // Deabruaren marrakiak
        DemBitmap = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.enemy1),
                BitmapFactory.decodeResource(getResources(), R.drawable.enemy2)
        };

        // Deabru objektua sortu
        demonico = new Demonico(DemBitmap);

        // Marrazkiak eskalatu
        for (int i = 0; i < DemBitmap.length; i++) {
            DemBitmap[i] = Bitmap.createScaledBitmap(DemBitmap[i], demonico.width, demonico.height, false);
        }

        // Grinch-aren marrakiak
        CarreyBitmap = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.grinch1),
                BitmapFactory.decodeResource(getResources(), R.drawable.grinch1)
        };

        // Grinch objektua sortu
        carrey = new JimCarrey(CarreyBitmap);

        // Grinch-ak eskalatu
        for (int i = 0; i < CarreyBitmap.length; i++) {
            CarreyBitmap[i] = Bitmap.createScaledBitmap(CarreyBitmap[i], carrey.width, carrey.height, false);
        }
        TurnoEnemigo();

        /**
         * Behekoa kendu daiteke
         */
          /*  GameActivity.hipoMusika.start();
        }else{
            GameActivity.grinchMusika.start();
        }*/
    }

    /**
     * View-aren haria da
     */
    @Override
    public void run() {
        while (isPlaying) {
            update();
            draw();
            sleep();
        }
    }

    /**
     * Jokuaren aldaketak egiten du
     */
    private void update() {
        tic++;
        rodolfo.update();
        GameActivity.puntuak++;
        if (orden) {
            JimCarrey.update();
        } else {
            Demonico.update();
        }

        background1.x -= backgroundSpeed;
        background2.x -= backgroundSpeed;

        if (tic % backgroundSpeedRatio == 0) {
            backgroundSpeed = +100;
            rodolfoSaltoKendu();
            rodolfoSadKendu();
        }

        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX - 5;
        }

        if (background2.x + background2.background.getWidth() < 0) {
            background2.x = screenX - 5;
        }
    }

    /**
     * Jokuaren aldaketak marrazten du
     */
    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();

            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(background2.background, background2.x, background2.y, paint);

            rodolfo.draw(canvas);

            if (orden) {
                JimCarrey.draw(canvas);
            } else {
                Demonico.draw(canvas);
            }

            if (isGameOver) {
                isPlaying = false;
                Rect fondo = new Rect(0, 0, screenX, screenY);
                canvas.drawRect(fondo, paint);
                Bitmap gameover = BitmapFactory.decodeResource(getResources(), R.drawable.gameover);
                gameover = Bitmap.createScaledBitmap(gameover, screenX / 2, screenY / 2, false);
                canvas.drawBitmap(gameover, (float) screenX / 4, (float) screenY / 4, paint);
                Log.d("Puntuak", Integer.toString(GameActivity.puntuak));

                getHolder().unlockCanvasAndPost(canvas);
                gameOver();
                return;
            }
            canvas.drawText(Integer.toString(GameActivity.puntuak), screenX / 2, 90, score);
            //canvas.drawBitmap(pause, screenX - 150, 50, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    /**
     * Saltoaren denbora kontrolatzeko
     */
    private void rodolfoSaltoKendu() {
        if (rodolfoSalto > 500) {
            rodolfoSalto = rodolfoSalto - 20;
        }
    }

    /**
     * Maurtzearen denbora kontrolatzeko
     */
    private void rodolfoSadKendu() {
        if (rodolfoDepre > 500) {
            rodolfoDepre = rodolfoDepre - 20;
        }
    }

    /**
     * GameOver pantailara doa
     */
    private void gameOver() {
        activity.startActivity(new Intent(activity, PerdisteActivity.class));
    }

    /**
     * FPS-en kontrola kudeatzeko
     */
    private void sleep() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Jokua berrezkuaratzen denean
     */
    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Jokua pausatzen denean
     */
    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Pantaila klikatzean
     *
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            // Pantaila klikatzen denean
            case MotionEvent.ACTION_DOWN:
                // Pantailaren eskumaldea klikatzean
                if (event.getX() > screenX / 2) {
                    if (!isBloqueao) {
                        RodolfoSalta();
                    }
                    // Pantailaren ezkerraldea klikatzean
                } else {
                    if (!isBloqueao) {
                        RodolfoDeprimio();
                    }
                }
                break;
        }
        return true;
    }

    /**
     * Makurtzearen aldaketak egiten du
     */
    private void RodolfoDeprimio() {
        isTocandoFondo = true;
        isBloqueao = true;

        try {
            GameActivity.aiiiMusika.start();
            Thread.sleep(rodolfoDepre);
            isTocandoFondo = false;
            Thread.sleep(200);
            isBloqueao = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saltoaren aldaketak egiten du
     */
    private void RodolfoSalta() {
        isJump = true;
        isBloqueao = true;
        try {
            GameActivity.naaahiMusika.start();
            Thread.sleep(rodolfoSalto);
            isJump = false;
            Thread.sleep(200);
            isBloqueao = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return zer etsai agertuko den
     */
    public static boolean TurnoEnemigo() {
        double r = Math.random();
        // Grinch-a agertuko da
        if (r < 0.5 && c1 < 3) {
            //GameActivity.grinchMusika.start();
            c1++;
            c2 = 0;
            orden = true;
            // Deabrua agertukok da
        } else if (r >= 0.5 && c2 < 3) {
            //GameActivity.hipoMusika.start();
            c2++;
            c1 = 0;
            orden = false;
        }
        return orden;
    }
}

