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
import com.example.supernaaahigame.model.Rudolph;

import java.util.Random;

public class JokuaView extends SurfaceView implements Runnable {
    // Haria
    private Thread haria;
    // Jolasten badago konprobatu
    private boolean jolasten = false;
    // Blokeoak egiteko (Ez du funtzionatzen)
    private boolean saltoEgiten = false;
    private boolean blokeoa;
    // Fondo
    private Fondoa fondoa1, fondoa2;
    // Pertsonaiak
    private Rudolph rudolph;
    private Demonio demonio;
    private Demonio[] demonioak;
    private Random random;
    // Pantailaren balioak
    private int screenX, screenY;
    private float screenRatioX, screenRatioY;
    // Paint
    private Paint paint;

    public JokuaView(JokuaActivity context, int screenX, int screenY) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;

        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        fondoa1 = new Fondoa(screenX, screenY, getResources());
        fondoa2 = new Fondoa(screenX, screenY, getResources());

        rudolph = new Rudolph(screenY, screenX, getResources(), screenRatioX, screenRatioY);

        demonioak = new Demonio[3];

        for (int i = 0; i < 3; i++) {

            demonio = new Demonio(screenY, screenX, getResources(), screenRatioX, screenRatioY);
            demonioak[i] = demonio;
        }

        random = new Random();

        fondoa2.setX(screenX);

        paint = new Paint();
    }

    @Override
    public void run() {
        while (jolasten) {
            update();
            draw();
            sleep();
        }
    }

    public void resume() {
        jolasten = true;
        haria = new Thread(this);
        haria.start();
    }

    public void pause() {
        jolasten = false;
        try {
            haria.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void itxi() {
        jolasten = false;
    }

    private void update() {
        fondoa1.x -= 15 * screenRatioX;
        fondoa2.x -= 15 * screenRatioX;

        if (fondoa1.getX() + fondoa1.getFondoa().getWidth() < 0) {
            fondoa1.setX(screenX);
        }
        if (fondoa2.getX() + fondoa2.getFondoa().getWidth() < 0) {
            fondoa2.setX(screenX);
        }
        if (saltoEgiten) {
            rudolph.setY(screenY - 2 * screenY / 3);
        } else {
            rudolph.setY(screenY - 2 * screenY / 5);
        }

        for (Demonio dem : demonioak) {

            dem.setX(dem.getX() - dem.getSpeed());
        }

        if (demonio.getX() + demonio.getWidth() < 0) {
            int bound = (int) (30 * screenRatioX);
            demonio.setSpeed(random.nextInt(bound));

            if (demonio.getSpeed() < 10 * screenRatioX)
                demonio.setSpeed((int) (10 * screenRatioX));

            demonio.setX(screenX);

        }


        if (Rect.intersects(demonio.getCollisionShape(), rudolph.getCollisionShape())) {

            //jolasten=false;
            return;
        }

    }

    private void draw() {
        Canvas canvas;
        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();

            canvas.drawBitmap(fondoa1.getFondoa(), fondoa1.getX(), fondoa1.getY(), paint);
            canvas.drawBitmap(fondoa2.getFondoa(), fondoa2.getX(), fondoa2.getY(), paint);

            if (saltoEgiten) {
                canvas.drawBitmap(rudolph.getRenoSaltoEgiten(), rudolph.getX(), rudolph.getY(), paint);
            } else {
                canvas.drawBitmap(rudolph.renoaAldatu(), rudolph.getX(), rudolph.getY(), paint);
            }

            for (Demonio dem : demonioak) {
                canvas.drawBitmap(dem.demonioaAldatu(), dem.getX(), dem.getY(), paint);
            }

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() > screenX / 2) {
                    if (!blokeoa) {
                        saltoEgin();
                    }

                } else {

                }
                break;
        }

        return true;
    }

    private void saltoEgin() {
        saltoEgiten = true;
        blokeoa = true;
        try {
            Thread.sleep(300);

            saltoEgiten = false;
            Thread.sleep(200);
            blokeoa = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
