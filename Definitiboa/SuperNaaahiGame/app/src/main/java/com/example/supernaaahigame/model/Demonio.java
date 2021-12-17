package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.supernaaahigame.R;

public class Demonio {
    private int x, y, width, height, demonio = 0;
    private Bitmap demonio1, demonio2;

    public Demonio(int screenY, int screenX, Resources res, float screenRatioX, float screenRatioY) {
        demonio1 = BitmapFactory.decodeResource(res, R.drawable.demonio1);
        demonio2 = BitmapFactory.decodeResource(res, R.drawable.demonio2);

        width = demonio1.getWidth() / 4;
        height = demonio1.getHeight() / 4;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        demonio1= Bitmap.createScaledBitmap(demonio1, width, height, false);
        demonio2 = Bitmap.createScaledBitmap(demonio2, width, height, false);

        y = screenY - 4*screenY/6;
        x = screenX/3;
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
}
