package com.example.supernaaahigame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread {
    private int FPS = 60;
    private double averageFPS;

    private SurfaceHolder surfaceHolder;
    private JokuaView jokuaView;
    private boolean jolasten;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, JokuaView jokuaView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.jokuaView = jokuaView;
    }

    public void setJolasten(boolean jolasten) {
        this.jolasten = jolasten;
    }

    @Override
    public void run() {

        while (jolasten) {
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();

                synchronized (surfaceHolder) {
                    this.jokuaView.update();
                    this.jokuaView.draw(canvas);
                }
            } catch (Exception ex) {

            } finally {
                if (canvas != null) {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                sleep(17);
            } catch (Exception e) {
            }
        }
    }
}

