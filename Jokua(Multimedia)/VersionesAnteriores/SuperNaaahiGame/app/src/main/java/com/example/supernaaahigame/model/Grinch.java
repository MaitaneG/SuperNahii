package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.supernaaahigame.R;

public class Grinch {
    private int speed = 40;
    private int x, y, width, height, grinch;
    private Bitmap grinch1, grinch2;

    public Grinch(int screenY, int screenX, Resources res, float screenRatioX, float screenRatioY) {
        grinch1 = BitmapFactory.decodeResource(res, R.drawable.grinch1);
        grinch2 = BitmapFactory.decodeResource(res, R.drawable.grinch1);

        width = grinch1.getWidth();
        height = grinch1.getHeight();

        width /= 8;
        height /= 8;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        grinch1 = Bitmap.createScaledBitmap(grinch1, width, height, false);
        grinch2 = Bitmap.createScaledBitmap(grinch2, width, height, false);

        y = screenY - 2 * screenY / 7;
        x = screenX;
    }

    public Bitmap grinchAldatu() {
        if (grinch == 0) {
            grinch++;
            return grinch1;
        }
        grinch--;
        return grinch2;
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
