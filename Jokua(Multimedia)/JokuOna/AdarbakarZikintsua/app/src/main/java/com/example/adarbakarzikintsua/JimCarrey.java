package com.example.adarbakarzikintsua;


import static com.example.adarbakarzikintsua.MainActivity.pointX;
import static com.example.adarbakarzikintsua.MainActivity.pointY;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Random;


public class JimCarrey {

    public int speed = 20;
    public boolean morision = true;
    int x = -1000, y;
    private static int enemyCounter = 0;
    public static int width, height;
    Rect collisionRect;
    private static Bitmap[] enemyBitmap;
    public static int enemyMinSpeed = 5, enemyMaxSpeed = 20;

    JimCarrey(Bitmap[] enemyBitmap) {
        this.enemyBitmap = enemyBitmap;
        width = (int) ((enemyBitmap[0].getWidth() / 5) * pointX);
        height = (int) ((enemyBitmap[0].getHeight() / 5) * pointY);
        y = GameView.screenY - this.height;

        collisionRect = new Rect(x, y, x + width, y + height);

    }

    public static void update(){

        //Enemyen abiadura denborarekin azkartzea
        if(GameView.tic % 50 ==0){
            enemyMaxSpeed++;
        }
        if(GameView.tic % 60 == 0){
            enemyMinSpeed++;
        }

        GameView.carrey.collisionRect = new Rect(GameView.carrey.x, GameView.carrey.y, GameView.carrey.x + width, GameView.carrey.y + height);
        GameView.carrey.x -= GameView.carrey.speed;
        if (GameView.carrey.x + JimCarrey.width < 0) {
            GameView.TurnoEnemigo();
            if (!GameView.carrey.morision && !GameView.debug) {
                GameView.isGameOver = true;
                return;
            }
            //int maxSpeed = (int) (enemyMaxSpeed * GameView.screenRatioX);
            //GameView.carrey.speed = random.nextInt(maxSpeed);
            if (GameView.carrey.speed < enemyMinSpeed * GameView.screenRatioX)
                GameView.carrey.speed = (int) (enemyMinSpeed * GameView.screenRatioX);

            GameView.carrey.x = GameView.screenX + 5;
            GameView.carrey.y = GameView.screenY - height-10;

            GameView.carrey.morision = false;
        }

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

