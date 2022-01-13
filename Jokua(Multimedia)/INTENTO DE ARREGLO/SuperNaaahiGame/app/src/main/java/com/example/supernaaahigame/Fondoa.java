package com.example.supernaaahigame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Fondoa {
    private int x = 0, y = 0;
    private Bitmap fondoa;

    public Fondoa(Bitmap fondoa) {
        this.fondoa = fondoa;
        //fondoa = Bitmap.createScaledBitmap(fondoa, JokuaView.screenX, (JokuaView.screenY-JokuaView.screenY/100), false);
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(fondoa, x, y, null);

        if (x < 0) {
            canvas.drawBitmap(fondoa, x + JokuaView.WIDTH, y, null);
        }
    }

    public void update() {
        x -= 10 ;

        if (x < -JokuaView.WIDTH) {
            x = 0;
        }
    }
}
