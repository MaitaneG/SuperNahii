package com.example.supernaaahigame.objects;

import android.widget.ImageView;

public class Reindeer {
    private ImageView argazkia;
    private int x;
    private int y;
    private int width;
    private int height;

    public Reindeer(ImageView argazkia, int x, int y) {
        this.argazkia = argazkia;
        this.x = x;
        this.y = y;
    }

    public ImageView getArgazkia() {
        return argazkia;
    }

    public void setArgazkia(ImageView argazkia) {
        this.argazkia = argazkia;
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
}
