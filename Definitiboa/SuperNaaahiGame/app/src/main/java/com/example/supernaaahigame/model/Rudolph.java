package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.supernaaahigame.R;

public class Rudolph {

    private int X, y, width, height, renoa = 0;
    private Bitmap renoIbiltzen1, renoIbiltzen2, renoSaltoEgiten, renoMakurtzen;

    public Rudolph(int screenY, Resources res, float screenRatioX, float screenRatioY) {
        renoIbiltzen1 = BitmapFactory.decodeResource(res, R.drawable.reno_andando);
        renoIbiltzen2 = BitmapFactory.decodeResource(res, R.drawable.reno_andando);
        renoSaltoEgiten = BitmapFactory.decodeResource(res, R.drawable.reno_saltando);


        width = renoIbiltzen1.getWidth();
        height = renoIbiltzen1.getHeight();

        // Ez dakigu nola irtengo den
        width /= 4;
        height /= 4;

        width *= (int) screenRatioX;
        height *= (int) screenRatioY;

        renoIbiltzen1 = Bitmap.createScaledBitmap(renoIbiltzen1, width, height, false);
        renoIbiltzen2 = Bitmap.createScaledBitmap(renoIbiltzen2, width, height, false);
        renoSaltoEgiten = Bitmap.createScaledBitmap(renoSaltoEgiten, width, height, false);
        renoMakurtzen = Bitmap.createScaledBitmap(renoMakurtzen, width, height, false);

        y = screenY / 2;
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
