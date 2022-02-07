package com.example.supernaaahigame.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.supernaaahigame.view.GameView;
import com.example.supernaaahigame.view.MainActivity;

/**
 * Oreina modeloaren klasea
 */
public class Rodolfo {

    Bitmap[] rodolfoBitmap;
    int x;
    int y;
    public int width;
    public int height;
    int rodolfoCounter = 0;
    Rect collisionRect;

    /**
     * Oreinaren konstruktorea
     *
     * @param rodolfoBitmap
     */
    public Rodolfo(Bitmap[] rodolfoBitmap) {
        this.rodolfoBitmap = rodolfoBitmap;
        // Width-a eta height-a zehaztu
        width = (int) ((rodolfoBitmap[0].getWidth() / 4) * MainActivity.pointX);
        height = (int) ((rodolfoBitmap[0].getHeight() / 4) * MainActivity.pointY);

        // X-a eta Y-a zehaztu
        y = GameView.screenY - this.height;
        x = 50;

        // Grinch-aren Hitbox-a definitu
        collisionRect = new Rect(width / 4 + 1, y + 1, x + width - 1, y + height - 1);
    }

    /**
     * Oreinaren aldaketak egiten du
     */
    public void update() {
        // Oreinaren Hitbox-a definitu
        collisionRect = new Rect(width / 4 + 1, y + 1, x + width - 1, y + height - 1);

        // Oreina deabruarekin talka egin duen konprobatu
        if (Rect.intersects(GameView.demonico.collisionRect, collisionRect) && !GameView.debug) {
            GameView.isGameOver = true;
            return;
        }

        // Oreina Grich-arekin talka egin duen konprobatu
        if (Rect.intersects(GameView.carrey.collisionRect, collisionRect) && !GameView.debug) {
            GameView.isGameOver = true;
            return;
        }

        // Salto egiteko klikatzen denean altuera aldatu
        if (GameView.isJump) {
            y = GameView.screenY / 5;
            // Makurtzeko klikatzen denean altuera aldatu
        } else if (GameView.isTocandoFondo) {
            y = GameView.screenY - this.height + 110;
            // Bestela altuera berdina mantendu
        } else {
            y = GameView.screenY - this.height;
        }
    }

    /**
     * Oreinaren aldaketak marraztu
     *
     * @param canvas
     */
    public void draw(Canvas canvas) {
        // debug true bada, Hitbox-a marrazten du
        if (GameView.debug)
            canvas.drawRect(collisionRect, GameView.pu);

        // Salto egiteko klikatzen denean salto argazkia jarri
        if (GameView.isJump) {
            canvas.drawBitmap(rodolfoBitmap[2], x, y, GameView.paint);
            // Makurtzeko klikatzen denean makurtu argazkia jarri
        } else if (GameView.isTocandoFondo) {
            canvas.drawBitmap(rodolfoBitmap[3], x, y, GameView.paint);
            // Oreina ibiltzearen lehengo argazkia jarri
        } else if (rodolfoCounter < 1) {
            rodolfoCounter++;
            canvas.drawBitmap(rodolfoBitmap[rodolfoCounter], x, y, GameView.paint);
            // Oreina ibiltzearen bigarren argazkia jarri
        } else {
            rodolfoCounter = 0;
            canvas.drawBitmap(rodolfoBitmap[rodolfoCounter], x, y, GameView.paint);
        }
    }
}
