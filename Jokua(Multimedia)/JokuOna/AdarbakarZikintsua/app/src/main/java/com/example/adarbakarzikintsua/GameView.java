package com.example.adarbakarzikintsua;

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

import java.util.Random;

public class GameView extends SurfaceView implements Runnable {

    public static float screenRatioX, screenRatioY;
    public static float inputX, inputY, inputX1, inputY1;
    public static Paint paint = null, pu = null, pe = null, pt = null, score = null;
    private final Background background1, background2;
    public static final boolean debug = true;
    public static int screenX, screenY;
    private Thread thread;
    private Random random;
    public static boolean isPlaying, isGameOver = false;
    public static Rodolfo rodolfo;
    public static Demonico demonico;
    public static JimCarrey carrey;
    private GameActivity activity;
    private Bitmap pause;
    public static int tic = 0, backgroundSpeed = 5, backgroundSpeedRatio = 50;
    private Bitmap[] DemBitmap;
    private Bitmap[] CarreyBitmap;
    private static boolean orden;
    private static int c1 = 0;
    private static int c2 = 0;


    public GameView(GameActivity activity, int sX, int sY) {
        super(activity);

        isGameOver = false;
        rodolfo = null;
        tic = 0;
        backgroundSpeed = 5;
        demonico.enemyMinSpeed = 5;
        demonico.enemyMaxSpeed = 20;

        Bitmap[] rodolfoBitmap = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.reno1),
                BitmapFactory.decodeResource(getResources(), R.drawable.reno2),
        };

        rodolfo = new Rodolfo(rodolfoBitmap);

        for (int i = 0; i < rodolfoBitmap.length; i++) {
            rodolfoBitmap[i] = Bitmap.createScaledBitmap(rodolfoBitmap[i], rodolfo.width, rodolfo.height, false);
        }

        GameActivity.puntuak = 0;

        this.activity = activity;

        this.screenX = sX;
        this.screenY = sY;
        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());

        pause = BitmapFactory.decodeResource(getResources(), R.drawable.pause);
        pause = Bitmap.createScaledBitmap(pause, 100, 100, false);

        background2.x = screenX;


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


        DemBitmap = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.enemy1),
                BitmapFactory.decodeResource(getResources(), R.drawable.enemy2)
        };

        demonico = new Demonico(DemBitmap);

        for(int i = 0; i < DemBitmap.length; i++){
            DemBitmap[i] = Bitmap.createScaledBitmap(DemBitmap[i], demonico.width, demonico.height, false);
        }

        CarreyBitmap = new Bitmap[]{
                BitmapFactory.decodeResource(getResources(), R.drawable.grinch1),
                BitmapFactory.decodeResource(getResources(), R.drawable.grinch1)
        };

        carrey = new JimCarrey(CarreyBitmap);

        for(int i = 0; i < CarreyBitmap.length; i++){
            CarreyBitmap[i] = Bitmap.createScaledBitmap(CarreyBitmap[i], carrey.width, carrey.height, false);
        }

        TurnoEnemigo();

    }





    @Override
    public void run() {

        while (isPlaying) {
            update();
            draw();
            sleep();
        }

    }

    private void update() {
        tic++;
        rodolfo.update();
        carrey.update();
        demonico.update();

        background1.x -= backgroundSpeed;
        background2.x -= backgroundSpeed;

        if (tic % backgroundSpeedRatio == 0) {
            backgroundSpeed++;
        }

        if (background1.x + background1.background.getWidth() < 0) {
            background1.x = screenX - 5;
        }

        if (background2.x + background2.background.getWidth() < 0) {
            background2.x = screenX - 5;
        }
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();

            canvas.drawBitmap(background1.background, background1.x, background1.y, paint);
            canvas.drawBitmap(background2.background, background2.x, background2.y, paint);

            rodolfo.draw(canvas);

            if(orden){
                carrey.draw(canvas);
            }else{
                demonico.draw(canvas);
            }


            if (isGameOver) {
                isPlaying = false;
                Rect fondo = new Rect(0, 0, screenX, screenY);
                canvas.drawRect(fondo, paint);
                Bitmap gameover = BitmapFactory.decodeResource(getResources(), R.drawable.gameover);
                gameover = Bitmap.createScaledBitmap(gameover, screenX / 2, screenY / 2, false);
                canvas.drawBitmap(gameover, (float) screenX / 4, (float) screenY / 4, paint);
                Log.d("puntuak", Integer.toString(GameActivity.puntuak));

                getHolder().unlockCanvasAndPost(canvas);
                gameOver();
                return;
            }
            canvas.drawText(Integer.toString(GameActivity.puntuak), screenX / 2, 90, score);
            canvas.drawBitmap(pause, screenX - 150, 50, paint);
            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void gameOver() {
        try {
            Thread.sleep(3000);

            activity.startActivity(new Intent(activity, PointsForm.class));
            activity.finish();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                int pointerIndex = event.getPointerCount();
                for (int i = 0; i < pointerIndex; i++) {
                    if (i == 0) {
                        inputX = event.getX(i);
                        inputY = event.getY(i);
                        touchKontrola((int) inputX, (int) inputY);
                    }
                    if (i == 1) {
                        inputX1 = event.getX(i);
                        inputY1 = event.getY(i);
                        touchKontrola((int) inputX1, (int) inputY1);
                    }
                }
                break;
            default:
                inputX = 0;
                inputY = 0;
                inputX1 = 0;
                inputY1 = 0;
                break;
        }
        return true;
    }

    public void touchKontrola(int X, int Y) {

    }

    public static boolean TurnoEnemigo(){

        boolean orden;

        if (Math.random() < 0.5){
            orden = false;

        }else{
            orden = true;

        }

        return  orden;
    }
}

