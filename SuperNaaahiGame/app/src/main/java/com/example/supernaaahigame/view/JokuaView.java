package com.example.supernaaahigame.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.os.Handler;
import android.widget.ImageButton;

import com.example.supernaaahigame.R;
import com.example.supernaaahigame.objects.Reindeer;


public class JokuaView extends View {

    private int screenWidth, screenHeight, newWidth, newHeight;
    private Bitmap mapa;
    private Bitmap mapaAldatuta;
    private Bitmap renoArgazkia;
    private Reindeer reno;

    private int mapaX = 0;
    private Handler handler;
    private Runnable runnable;
    private final long UPDATE_MILLIS = 30;

    private int i=0;


    public JokuaView(Context context) {
        super(context);

        // Mapak kargatu
        mapa = BitmapFactory.decodeResource(getResources(), R.drawable.fondo_lehenego_posizioa);
        mapaAldatuta = BitmapFactory.decodeResource(getResources(), R.drawable.fondo_bigarren_posizioa);
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        screenWidth = size.x;
        screenHeight = size.y;

        float height = mapa.getHeight();
        float width = mapa.getWidth();
        float ratio = width / height;
        newHeight = screenHeight;
        newWidth = (int) (ratio * screenHeight);

        mapa = Bitmap.createScaledBitmap(mapa, newWidth, newHeight, false);
        mapaAldatuta = Bitmap.createScaledBitmap(mapaAldatuta, newWidth, newHeight, false);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };

        // Oreina kargatu
        renoArgazkia=BitmapFactory.decodeResource(getResources(),R.drawable.reno_andando);
        reno= new Reindeer(renoArgazkia,400, 400, 100,690);
        renoArgazkia = Bitmap.createScaledBitmap(renoArgazkia, reno.getWidth(), reno.getHeight(), false);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mapaX -= (2);

        if (mapaX < - newWidth) {
            mapaX = 0;
        }
        canvas.drawBitmap(mapa, mapaX, 0, null);

        if (mapaX < screenWidth - newWidth) {
            if(i==0){
                canvas.drawBitmap(mapa, mapaX + newWidth, 0, null);
            }else{
                canvas.drawBitmap(mapaAldatuta, mapaX + newWidth, 0, null);
            }
            i++;
        }
        handler.postDelayed(runnable, UPDATE_MILLIS);

        canvas.drawBitmap(renoArgazkia, reno.getX(), reno.getY(), null);
    }
}
