package com.example.supernaaahigame.model;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.supernaaahigame.view.GameView;
import com.example.supernaaahigame.view.MainActivity;


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

    public JimCarrey(Bitmap[] enemyBitmap) {
        this.enemyBitmap = enemyBitmap;
        width = (int) ((enemyBitmap[0].getWidth() / 5) * MainActivity.pointX);
        height = (int) ((enemyBitmap[0].getHeight() / 5) * MainActivity.pointY);
        y = GameView.screenY - this.height;

        collisionRect = new Rect(x, y, x + width, y + height);

    }

    public static void update(){

        //Enemyen abiadura denborarekin azkartzea
        if(GameView.tic % 50 ==0){
            enemy2Speed++;
        }

        GameView.carrey.collisionRect = new Rect(GameView.carrey.x, GameView.carrey.y, GameView.carrey.x + width, GameView.carrey.y + height);
        GameView.carrey.x -= GameView.carrey.speed;
        if ((GameView.carrey.x + width) + GameView.carrey.width <= 0) {
            GameView.carrey.speed = (int) (enemy2Speed * GameView.screenRatioX);
            GameView.carrey.x = GameView.screenX + 5;
            GameView.carrey.y = GameView.screenY - height-10;
            if(sumaputoJimmy){
                //GameActivity.puntuak++;
            }
            GameView.carrey.morision = false;
            GameView.TurnoEnemigo();
        }
        sumaputoJimmy = true;

    }



    public static void draw(Canvas canvas){
        canvas.drawBitmap(enemyBitmap[0], GameView.carrey.x, GameView.carrey.y, GameView.paint);
        if (GameView.debug)
            canvas.drawRect(GameView.carrey.collisionRect, GameView.pe);

        if(GameView.tic%3 ==0){
            if(enemyCounter==1){
                enemyCounter=0;
            }else {
                enemyCounter++;
            }
        }
    }
}

