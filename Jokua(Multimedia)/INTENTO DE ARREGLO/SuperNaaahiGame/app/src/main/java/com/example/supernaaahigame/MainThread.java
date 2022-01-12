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
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount =0;
        long targetTime = 1000/FPS;

        while (jolasten) {
            startTime = System.nanoTime();
            canvas = null;

            try {
                canvas = this.surfaceHolder.lockCanvas();

                synchronized (surfaceHolder){
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
            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMillis;

            try{
                this.sleep(waitTime);
            }catch(Exception e){}

            totalTime += System.nanoTime()-startTime;
            frameCount++;
            if(frameCount == FPS)
            {
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount =0;
                totalTime = 0;
                System.out.println(averageFPS);
            }
        }
        }
    }

