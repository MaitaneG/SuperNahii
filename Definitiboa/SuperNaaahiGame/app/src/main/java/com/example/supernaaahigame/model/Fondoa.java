package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.supernaaahigame.R;

public class Fondoa {

    private int x=0, y=0;
    private Bitmap fondoa;

    public Fondoa(int screenX, int screenY, Resources res){
        fondoa= BitmapFactory.decodeResource(res, R.drawable.fondo_bigarren_posizioa);
        fondoa= Bitmap.createScaledBitmap(fondoa,screenX,screenY,false);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Bitmap getFondoa() {
        return fondoa;
    }

    public void setFondoa(Bitmap fondoa) {
        this.fondoa = fondoa;
    }
}
