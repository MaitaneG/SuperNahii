package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.supernaaahigame.R;

public class Rudolph {

    private int X, y, width, height;
    private Bitmap renoIbiltzen1, renoIbiltzen2, renoSaltoEgiten, renoMakurtzen;

    public Rudolph(int screenY, Resources res) {
        renoIbiltzen1 = BitmapFactory.decodeResource(res, R.drawable.reno_andando);
        renoSaltoEgiten = BitmapFactory.decodeResource(res, R.drawable.re);
        renoIbiltzen1 = BitmapFactory.decodeResource(res, R.drawable.reno_andando);

        width = renoIbiltzen1.getWidth();
        height = renoIbiltzen1.getHeight();

        // Ez dakigu nola irtengo den
        width /= 4;
        height /= 4;

    }

    public int getX() {
        return X;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Bitmap getRenoIbiltzen1() {
        return renoIbiltzen1;
    }

    public Bitmap getRenoIbiltzen2() {
        return renoIbiltzen2;
    }

    public Bitmap getRenoSaltoEgiten() {
        return renoSaltoEgiten;
    }

    public Bitmap getRenoMakurtzen() {
        return renoMakurtzen;
    }
}
