package com.example.supernaaahigame.model;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.supernaaahigame.view.GameView;
import com.example.supernaaahigame.view.MainActivity;

/**
 * Grinch-aren modeloaren klasea da
 */
public class JimCarrey {

    public int speed = 20;
    public boolean morision = true;
    int x = -1000, y;
    private static int enemyCounter = 0;
    public static int width, height;
    Rect collisionRect;
    private static Bitmap[] enemyBitmap;
    public static int enemy2Speed = 20;
    public static boolean sumaputoJimmy;

    /**
     * Grinch-aren konstruktorea
     *
     * @param enemyBitmap
     */
    public JimCarrey(Bitmap[] enemyBitmap) {
        this.enemyBitmap = enemyBitmap;
        // Width-a eta height-a zehaztu
        width = (int) ((enemyBitmap[0].getWidth() / 5) * MainActivity.pointX);
        height = (int) ((enemyBitmap[0].getHeight() / 5) * MainActivity.pointY);
        y = GameView.screenY - this.height;

        // Grinch-aren Hitbox-a definitu
        collisionRect = new Rect(x, y, x + width, y + height);
    }

    /**
     * Grinch-aren aldaketak egiten du
     */
    public static void update() {
        // Etsaien abiadura denborarekin azkartzea
        if (GameView.tic % 50 == 0) {
            enemy2Speed++;
        }

        // Deabruaren Hitbox-a eguneratu
        GameView.carrey.collisionRect = new Rect(GameView.carrey.x, GameView.carrey.y, GameView.carrey.x + width, GameView.carrey.y + height);

        // Deabruaren x-a, y-a aldatu
        GameView.carrey.x -= GameView.carrey.speed;
        if ((GameView.carrey.x + width) + GameView.carrey.width <= 0) {
            GameView.carrey.speed = (int) (enemy2Speed * GameView.screenRatioX);
            GameView.carrey.x = GameView.screenX + 5;
            GameView.carrey.y = GameView.screenY - height - 10;

            GameView.carrey.morision = false;
            GameView.TurnoEnemigo();
        }
        sumaputoJimmy = true;
    }

    /**
     * Grich-aren aldaketak marraztu
     *
     * @param canvas
     */
    public static void draw(Canvas canvas) {
        // Grinch-a marrazten du
        canvas.drawBitmap(enemyBitmap[0], GameView.carrey.x, GameView.carrey.y, GameView.paint);

        // debug true bada, Hitbox-a marrazten du
        if (GameView.debug)
            canvas.drawRect(GameView.carrey.collisionRect, GameView.pe);

        if (GameView.tic % 3 == 0) {
            if (enemyCounter == 1) {
                enemyCounter = 0;
            } else {
                enemyCounter++;
            }
        }
    }
}

