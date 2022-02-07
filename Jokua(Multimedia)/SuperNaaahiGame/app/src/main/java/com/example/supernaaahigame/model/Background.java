package com.example.supernaaahigame.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.supernaaahigame.R;

/**
 * Fondoaren modeloaren klasea da
 */
public class Background {

    public int x = 0;
    public int y = 0;
    public Bitmap background;

    /**
     * Fondoaren konstruktorea
     *
     * @param screenX
     * @param screenY
     * @param res
     */
    public Background(int screenX, int screenY, Resources res) {
        // Argazkia Bitmap bihurtu
        background = BitmapFactory.decodeResource(res, R.drawable.background);
        // Bitmap-a eskalatu
        background = Bitmap.createScaledBitmap(background, screenX, screenY, false);
    }
}
