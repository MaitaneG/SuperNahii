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

import com.example.supernaaahigame.R;


public class JokuaView extends View {

    private int screenWidth, screenHeight, newWidth, newHeight;
    private Bitmap mapa;
    private Bitmap reno;

    private int mapaX = 0;
    private Handler handler;
    private Runnable runnable;
    private final long UPDATE_MILLIS = 30;


    public JokuaView(Context context) {
        super(context);
        mapa = BitmapFactory.decodeResource(getResources(), R.drawable.fondo_hasiera);
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

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mapaX -= 2;

        if (mapaX < -newWidth) {
            mapaX = 0;
        }
        canvas.drawBitmap(mapa, mapaX, 0, null);

        if (mapaX < screenWidth - newWidth) {
            canvas.drawBitmap(mapa, mapaX + newWidth, 0, null);
        }
        handler.postDelayed(runnable, UPDATE_MILLIS);
    }
}
