package com.example.supernaaahigame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Deabrua {
    private int speed = 40;
    private int x, y, width, height, deabrua = 0;
    private Bitmap deabrua1, deabrua2;  

    public Deabrua(Resources res, float screenRatioX, float screenRatioY) {
        deabrua1 = BitmapFactory.decodeResource(res, R.drawable.deabrua1);
        deabrua2 = BitmapFactory.decodeResource(res, R.drawable.deabrua2);

        width = deabrua1.getWidth();
        height = deabrua1.getHeight();

        width = 2 * width / 6;
        height = 2 * height / 6;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        deabrua1 = Bitmap.createScaledBitmap(deabrua1, width, height, false);
        deabrua2 = Bitmap.createScaledBitmap(deabrua2, width, height, false);

        //y = JokuaView.screenY - 3 * JokuaView.screenY / 6;
        //x = JokuaView.screenX;
    }

    public void draw(Canvas canvas){
        if (deabrua == 0) {
            deabrua++;
            canvas.drawBitmap(deabrua1,x,y,null);
        }
        deabrua--;
        canvas.drawBitmap(deabrua2,x,y,null);
    }

    public void update(){

    }
}
