package com.example.adarbakarzikintsua.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.example.adarbakarzikintsua.R;

public class Background {

    public int x = 0;
    public int y = 0;
    public Bitmap background;

    public Background(int screenX, int screenY, Resources res) {

        background = BitmapFactory.decodeResource(res, R.drawable.background);
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);

    }
}
