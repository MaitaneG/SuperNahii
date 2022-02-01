package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.supernaaahigame.R;

public class Demonio {
    private int speed = 40;
    private int x, y, width, height, demonio = 0;
    private Bitmap demonio1, demonio2;

    public Demonio(int screenY, int screenX, Resources res, float screenRatioX, float screenRatioY) {
        demonio1 = BitmapFactory.decodeResource(res, R.drawable.demonio1);
        demonio2 = BitmapFactory.decodeResource(res, R.drawable.demonio2);

        width = demonio1.getWidth();
        height = demonio1.getHeight();

        width = 2 * width / 6;
        height = 2 * height / 6;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        demonio1 = Bitmap.createScaledBitmap(demonio1, width, height, false);
        demonio2 = Bitmap.createScaledBitmap(demonio2, width, height, false);

        y = screenY - 3 * screenY / 6;
        x = screenX;
    }

    public Bitmap demonioaAldatu() {
        if (demonio == 0) {
            demonio++;
            return demonio1;
        }
        demonio--;
        return demonio2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getWidth() {
        return width;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void draw(Canvas canvas, Paint paint) {
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(3);
        canvas.drawRect(x, y, x + width, y + height, paint);
    }

    public Rect getCollisionShape() {
        return new Rect(x, y, x + width, y + height);
    }
}
