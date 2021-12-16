package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.supernaaahigame.R;

public class Fondoa {
    private int X, y, width, height;
    private Bitmap fondoa;

    public Fondoa(int screenX, int screenY, Resources res){
        fondoa= BitmapFactory.decodeResource(res, R.drawable.fondo_hasiera);
        fondoa= Bitmap.createScaledBitmap(fondoa,screenX,screenY,false);
    }
}
