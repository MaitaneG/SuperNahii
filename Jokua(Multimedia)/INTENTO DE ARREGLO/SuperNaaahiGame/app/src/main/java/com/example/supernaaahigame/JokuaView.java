package com.example.supernaaahigame;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class JokuaView extends SurfaceView implements SurfaceHolder.Callback{

    private MainThread haria;
    public static int screenX, screenY;
    //public static final int WIDTH = 543, HEIGHT = 360;
    public static final int WIDTH = 856, HEIGHT = 480;
    private Fondoa fondoa1, fondoa2;
    private Deabrua deabrua;

    public JokuaView(Context context, int screenX, int screenY) {
        super(context);

//        JokuaView.screenX =screenX;
//        JokuaView.screenY =screenY;

        getHolder().addCallback(this);

        haria = new MainThread(getHolder(),this);
        setFocusable(true);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        fondoa1= new Fondoa(BitmapFactory.decodeResource(getResources(), R.drawable.kaka));
        fondoa2= new Fondoa(BitmapFactory.decodeResource(getResources(), R.drawable.kaka));
        //deabrua = new Deabrua(getResources(), screenRatioX, screenRatioY);

        haria.setJolasten(true);
        haria.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry =true;
        while (retry){
            try{
                haria.setJolasten(false);
                haria.join();
            }catch (InterruptedException ex){
                retry=false;
            }
        }
    }

    public void update() {
        fondoa1.update();
        fondoa2.update();
        //deabrua.update();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        final float scaleFactorX = getWidth()/WIDTH;
        final float scaleFactorY = getHeight()/HEIGHT;

        if(canvas!=null){
            final int savedState = canvas.save();
            canvas.scale(scaleFactorX,scaleFactorY);

            //deabrua.draw(canvas);
            fondoa1.draw(canvas);
            fondoa2.draw(canvas);
            canvas.restoreToCount(savedState);
        }
    }
}
