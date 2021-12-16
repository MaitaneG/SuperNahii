package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.supernaaahigame.R;

public class Rudolph {

    private int X, y, width, height;
    private Bitmap reno1;

    public Rudolph(int screenY, Resources res) {
        reno1 = BitmapFactory.decodeResource(res, R.drawable.reno_andando);

        width = reno1.getWidth();
        height = reno1.getHeight();

        // Ez dakigu nola irtengo den
        width /= 4;
        height /= 4;


    }

}
