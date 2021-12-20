package com.example.supernaaahigame.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.example.supernaaahigame.model.Demonio;
import com.example.supernaaahigame.model.Fondoa;
import com.example.supernaaahigame.model.Rudolph;

public class JokuaView extends SurfaceView implements Runnable {
    private Thread haria;
    private boolean jolasten;
    private boolean saltoEgiten;
    private Fondoa fondoa1, fondoa2;
    private Rudolph rudolph;
    private Demonio demonio;
    private int screenX, screenY;
    private float screenRatioX, screenRatioY;
    private Paint paint;

    public JokuaView(Context context, int screenX, int screenY) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;

        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        fondoa1 = new Fondoa(screenX, screenY, getResources());
        fondoa2 = new Fondoa(screenX, screenY, getResources());

        rudolph = new Rudolph(screenY, screenX, getResources(), screenRatioX, screenRatioY);

        demonio = new Demonio(screenY, screenX, getResources(), screenRatioX, screenRatioY);

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

            canvas.drawBitmap(demonio.demonioaAldatu(), demonio.getX(), demonio.getY(), paint);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() > screenX / 2) {
                    saltoEgin();
                } else {

                }
                break;
        }

        return true;
    }

    private void saltoEgin() {

        if (!saltoEgiten) {
            saltoEgiten = true;
            try {
                Thread.sleep(500);

                saltoEgiten = false;
                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            Log.d("a", "a");
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
