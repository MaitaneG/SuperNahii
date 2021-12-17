package com.example.supernaaahigame;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;

public class JokuaView extends SurfaceView implements Runnable {
    private Thread haria;
    private boolean jolasten;

    public JokuaView(Context context) {
        super(context);
    }

    @Override
    public void run() {
        while (jolasten) {
            update();
            invalidate();
            sleep();
        }
    }

    private void update() {
    }

    private void resume() {
        haria = new Thread(this);
        haria.start();
    }

    private void itxi() {
        jolasten = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    private void sleep() {
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
