package com.example.supernaaahigame.objects;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.supernaaahigame.R;

public class Reindeer {
    private Bitmap argazkia;
    private int x;
    private int y;
    private int width;
    private int height;

    public Reindeer(Bitmap argazkia, int width, int height, int x, int y) {
        this.argazkia= argazkia;
        this.width=width;
        this.height=height;
        this.x=x;
        this.y=y;
    }

    public Bitmap getArgazkia() {
        return argazkia;
    }

    public void setArgazkia(Bitmap argazkia) {
        this.argazkia = argazkia;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x + 10;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
