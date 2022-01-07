package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.supernaaahigame.R;

public class Rudolph {

    private int x, y, width, height, renoa = 0;
    private Bitmap renoIbiltzen1, renoIbiltzen2, renoSaltoEgiten, renoMakurtzen;

    public Rudolph(int screenY, int screenX, Resources res, float screenRatioX, float screenRatioY) {
        renoIbiltzen1 = BitmapFactory.decodeResource(res, R.drawable.reno_andando1);
        renoIbiltzen2 = BitmapFactory.decodeResource(res, R.drawable.reno_andando2);
        renoSaltoEgiten = BitmapFactory.decodeResource(res, R.drawable.reno_saltando);
        renoMakurtzen = BitmapFactory.decodeResource(res, R.drawable.reno_agachado);

        width = renoIbiltzen1.getWidth() / 2;
        height = renoIbiltzen1.getHeight() / 2;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        renoIbiltzen1 = Bitmap.createScaledBitmap(renoIbiltzen1, width, height, false);
        renoIbiltzen2 = Bitmap.createScaledBitmap(renoIbiltzen2, width, height, false);
        renoSaltoEgiten = Bitmap.createScaledBitmap(renoSaltoEgiten, width, height, false);
        renoMakurtzen = Bitmap.createScaledBitmap(renoMakurtzen, width, (height-100), false);

        y = screenY - 2 * screenY / 5;
        x = screenX / 3;
    }

    public Bitmap renoaAldatu() {
        if (renoa == 0) {
            renoa++;
            return renoIbiltzen1;
        }
        renoa--;
        return renoIbiltzen2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Bitmap getRenoSaltoEgiten() {
        return renoSaltoEgiten;
    }

    public Bitmap getRenoMakurtzen() {
        return renoMakurtzen;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setY(int y) {
        this.y = y;
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
