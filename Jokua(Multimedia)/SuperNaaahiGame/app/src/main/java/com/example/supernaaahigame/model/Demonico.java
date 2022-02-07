package com.example.supernaaahigame.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.supernaaahigame.view.GameView;
import com.example.supernaaahigame.view.MainActivity;

/**
 * Deabruaren modeloaren klasea da
 */
public class Demonico {

    public int speed = 20;
    public boolean morision = true;
    int x = -1000, y;
    private static int enemyCounter = 0;
    public static int width, height;
    Rect collisionRect;
    private static Bitmap[] enemyBitmap;
    public static int enemy1Speed = 20;
    private static boolean sumaputodemonico = false;

    /**
     * Deabruaren konstruktorea
     *
     * @param enemyBitmap
     */
    public Demonico(Bitmap[] enemyBitmap) {
        this.enemyBitmap = enemyBitmap;
        // Width-a eta height-a zehaztu
        width = (int) ((enemyBitmap[0].getWidth() / 8) * MainActivity.pointX);
        height = (int) ((enemyBitmap[0].getHeight() / 8) * MainActivity.pointY);
        y = GameView.screenY / (int) 2.5;

        // Deabruaren Hitbox-a definitu
        collisionRect = new Rect(x, y, x + width, y + height);
    }

    /**
     * Deabruaren aldaketak egiten du
     */
    public static void update() {
        //Etsaien abiadura denborarekin azkartzea
        if (GameView.tic % 50 == 0) {
            enemy1Speed++;
        }

        // Deabruaren Hitbox-a eguneratu
        GameView.demonico.collisionRect = new Rect(GameView.demonico.x, GameView.demonico.y, GameView.demonico.x + width, GameView.demonico.y + height);

        // Deabruaren x-a, y-a aldatu
        GameView.demonico.x -= GameView.demonico.speed;
        if ((GameView.demonico.x + width) + GameView.demonico.width <= 0) {
            GameView.demonico.speed = (int) (enemy1Speed * GameView.screenRatioX);
            GameView.demonico.x = GameView.screenX + 5;
            GameView.demonico.y = GameView.screenY - (int) (height * 2.5);

            GameView.demonico.morision = false;
            GameView.TurnoEnemigo();
        }
        sumaputodemonico = true;
    }

    /**
     * Deabruaren aldaketak marrazten du
     * @param canvas
     */
    public static void draw(Canvas canvas) {
        // Deabrua marrazten du
        canvas.drawBitmap(enemyBitmap[enemyCounter], GameView.demonico.x, GameView.demonico.y, GameView.paint);

        // debug true bada, Hitbox-a marrazten du
        if (GameView.debug)
            canvas.drawRect(GameView.demonico.collisionRect, GameView.pe);

        if (GameView.tic % 3 == 0) {
            if (enemyCounter == 1) {
                enemyCounter = 0;
            } else {
                enemyCounter++;
            }
        }
    }
}