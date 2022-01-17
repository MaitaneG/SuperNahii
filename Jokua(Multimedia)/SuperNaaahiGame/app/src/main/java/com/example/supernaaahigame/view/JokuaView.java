package com.example.supernaaahigame.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.example.supernaaahigame.model.Demonio;
import com.example.supernaaahigame.model.Fondoa;
import com.example.supernaaahigame.model.Grinch;
import com.example.supernaaahigame.model.Rudolph;

import java.util.Random;

/**
 * Jokuaren view-a
 */
public class JokuaView extends SurfaceView implements Runnable {
    // Haria
    private Thread haria;
    // Jolasten badago konprobatu
    private boolean jolasten = false, saltoEgiten, makurtzen, blokeoa;
    // Fondo
    private Fondoa fondoa1, fondoa2;
    // Pertsonaiak
    private Rudolph rudolph; // Rudolph
    private Demonio demonio; // Demoioa
    private Demonio[] demonioak;
    private Grinch grinch;  // Grinch
    private Grinch[] grinchak;
    private Random random;
    // Pantailaren balioak
    private int screenX, screenY;
    private float screenRatioX, screenRatioY;
    // Paint
    private Paint paint;

    /**
     * JokuaView klasea
     *
     * @param context
     * @param screenX
     * @param screenY
     */
    public JokuaView(JokuaActivity context, int screenX, int screenY) {
        super(context);

        // Pantaila
        this.screenX = screenX;
        this.screenY = screenY;

        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        fondoa1 = new Fondoa(screenX, screenY, getResources());
        fondoa2 = new Fondoa(screenX, screenY, getResources());

        // Rudolph
        rudolph = new Rudolph(screenY, screenX, getResources(), screenRatioX, screenRatioY);

        // Demonioa
        demonioak = new Demonio[3];

        for (int i = 0; i < 3; i++) {

            demonio = new Demonio(screenY, screenX, getResources(), screenRatioX, screenRatioY);
            demonioak[i] = demonio;
        }

        // Grinch
        grinchak = new Grinch[3];

        for (int i = 0; i < 3; i++) {

            grinch = new Grinch(screenY, screenX, getResources(), screenRatioX, screenRatioY);
            grinchak[i] = grinch;
        }

        random = new Random();

        fondoa2.setX(screenX);

        paint = new Paint();
    }

    /**
     * Runnable metodoa
     */
    @Override
    public void run() {
        while (jolasten) {
            update();
            draw();
            sleep();
        }
    }

    /**
     * Haria hasi
     */
    public void resume() {
        jolasten = true;
        haria = new Thread(this);
        haria.start();
    }

    /**
     * Haria pausatu
     */
    public void pause() {
        jolasten = false;
        try {
            haria.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Haria itxj
     */
    private void itxi() {
        jolasten = false;
    }

    /**
     * Aldaketak egiten du
     */
    private void update() {
        // Fondoa
        fondoa1.x -= 15 * screenRatioX;
        fondoa2.x -= 15 * screenRatioX;

        if (fondoa1.getX() + fondoa1.getFondoa().getWidth() < 0) {
            fondoa1.setX(screenX);
        }
        if (fondoa2.getX() + fondoa2.getFondoa().getWidth() < 0) {
            fondoa2.setX(screenX);
        }

        // Rudolph
        if (saltoEgiten) {
            rudolph.setY(screenY - 2 * screenY / 3);
        } else if (makurtzen) {
            rudolph.setY(rudolph.getY());
        } else {
            rudolph.setY(screenY - 2 * screenY / 5);
        }

        // Demonioa
        for (Demonio dem : demonioak) {

            dem.setX(dem.getX() - dem.getSpeed());
        }

        if (demonio.getX() + demonio.getWidth() < 0) {
            int bound = (int) (30 * screenRatioX);
            /*demonio.setSpeed(random.nextInt(bound));

             // Para que no vaya muy lento
             if (demonio.getSpeed() < 10 * screenRatioX)
             demonio.setSpeed((int) (10 * screenRatioX));*/

            demonio.setX(screenX);
        }

        // Grinch-a
        for (Grinch grinch : grinchak) {

            grinch.setX(grinch.getX() - grinch.getSpeed());
        }

        if (grinch.getX() + grinch.getWidth() < 0) {
            int bound = (int) (30 * screenRatioX);
            /*grinch.setSpeed(random.nextInt(bound));

            // Para que no vaya muy lento
            if (grinch.getSpeed() < 10 * screenRatioX)
                grinch.setSpeed((int) (10 * screenRatioX));*/

            grinch.setX(screenX);
        }

        // Colisones demonio y rudolph
        if (Rect.intersects(demonio.getCollisionShape(), rudolph.getCollisionShape())) {
            //jolasten=false;
            return;
        }

        // Colisones grinch y rudolph
        if (Rect.intersects(grinch.getCollisionShape(), rudolph.getCollisionShape())) {
            //jolasten=false;
            return;
        }
    }

    /**
     * Aldaketak marrazten ditu
     */
    private void draw() {
        Canvas canvas;
        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();

            // Fondoa
            canvas.drawBitmap(fondoa1.getFondoa(), fondoa1.getX(), fondoa1.getY(), paint);
            canvas.drawBitmap(fondoa2.getFondoa(), fondoa2.getX(), fondoa2.getY(), paint);

            rudolph.draw(canvas, paint);

            // Rudolph
            if (saltoEgiten) {
                canvas.drawBitmap(rudolph.getRenoSaltoEgiten(), rudolph.getX(), rudolph.getY(), paint);
            } else if (makurtzen) {
                canvas.drawBitmap(rudolph.getRenoMakurtzen(), rudolph.getX(), rudolph.getY(), paint);
            } else {
                canvas.drawBitmap(rudolph.renoaAldatu(), rudolph.getX(), rudolph.getY(), paint);
            }

            demonio.draw(canvas, paint);

            // Demonioa
            for (Demonio dem : demonioak) {
                canvas.drawBitmap(dem.demonioaAldatu(), dem.getX(), dem.getY(), paint);
            }

            grinch.draw(canvas, paint);
            // Grinch-a
            for (Grinch grinch : grinchak) {
                canvas.drawBitmap(grinch.grinchAldatu(), grinch.getX(), grinch.getY(), paint);
            }

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    /**
     * Pantaila ikutzen denean
     *
     * @param event
     * @return booleano bat
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() > screenX / 2) {
                    if (!blokeoa) {
                        saltoEgin();
                    }
                } else {
                    if (!blokeoa) {
                        makurtu();
                    }
                }
                break;
        }
        return true;
    }

    private void makurtu() {
        makurtzen = true;
        blokeoa = true;

        try {
            Thread.sleep(500);

            makurtzen = false;
            Thread.sleep(200);
            blokeoa = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saltoaren aldaketak egiten du
     */
    private void saltoEgin() {
        saltoEgiten = true;
        blokeoa = true;
        try {
            Thread.sleep(500);

            saltoEgiten = false;
            Thread.sleep(200);
            blokeoa = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Haria lokartzen du
     */
    private void sleep() {
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
