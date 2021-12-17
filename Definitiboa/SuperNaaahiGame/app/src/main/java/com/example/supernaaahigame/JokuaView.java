package com.example.supernaaahigame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceView;

import com.example.supernaaahigame.model.Fondoa;

public class JokuaView extends SurfaceView implements Runnable {
    private Thread haria;
    private boolean jolasten;
    private Fondoa fondoa1, fondoa2;
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

    private void update() {
        fondoa1.x -= 10 * screenRatioX;
        fondoa2.x -= 10 * screenRatioX;

        if (fondoa1.getX() + fondoa1.getFondoa().getWidth() < 0) {
            fondoa1.setX(screenX);
        }
        if (fondoa2.getX() + fondoa2.getFondoa().getWidth() < 0) {
            fondoa2.setX(screenX);
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

    private void draw() {
        Canvas canvas;
        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();

            canvas.drawBitmap(fondoa1.getFondoa(), fondoa1.getX(), fondoa1.getY(), paint);
            canvas.drawBitmap(fondoa2.getFondoa(), fondoa2.getX(), fondoa2.getY(), paint);

            getHolder().unlockCanvasAndPost(canvas);
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
