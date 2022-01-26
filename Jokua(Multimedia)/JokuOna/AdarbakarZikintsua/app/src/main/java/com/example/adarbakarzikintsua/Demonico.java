package com.example.adarbakarzikintsua;


import static com.example.adarbakarzikintsua.MainActivity.pointX;
import static com.example.adarbakarzikintsua.MainActivity.pointY;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;


public class Demonico {

    public int speed = 20;
    public boolean morision = true;
    int x = -1000, y;
    private static int enemyCounter = 0;
    public static int width, height;
    Rect collisionRect;
    private static Bitmap[] enemyBitmap;
    public static int enemyMinSpeed = 5, enemyMaxSpeed = 20;

    Demonico(Bitmap[] enemyBitmap) {
        this.enemyBitmap = enemyBitmap;
        width = (int) ((enemyBitmap[0].getWidth() / 8) * pointX);
        height = (int) ((enemyBitmap[0].getHeight() / 8) * pointY);
        y = GameView.screenY/(int)2.5;

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

        GameView.demonico.collisionRect = new Rect(GameView.demonico.x, GameView.demonico.y, GameView.demonico.x + width, GameView.demonico.y + height);
            GameView.demonico.x -= GameView.demonico.speed;
            if (GameView.demonico.x + GameView.demonico.width < 0) {
                GameView.TurnoEnemigo();
                if (!GameView.demonico.morision && !GameView.debug) {
                    GameView.isGameOver = true;
                    return;
                }
                //int maxSpeed = (int) (enemyMaxSpeed * GameView.screenRatioX);
                //GameView.demonico.speed = random.nextInt(maxSpeed);
                if (GameView.demonico.speed < enemyMinSpeed * GameView.screenRatioX)
                    GameView.demonico.speed = (int) (enemyMinSpeed * GameView.screenRatioX);

                GameView.demonico.x = GameView.screenX + 5;
                GameView.demonico.y = GameView.screenY - (int)(height * 2.5);

                GameView.demonico.morision = false;
            }

        }

    

    public static void draw(Canvas canvas){
        
            canvas.drawBitmap(enemyBitmap[enemyCounter], GameView.demonico.x, GameView.demonico.y, GameView.paint);
            if (GameView.debug)
                canvas.drawRect(GameView.demonico.collisionRect, GameView.pe);
        
        if(GameView.tic%3 ==0){
            if(enemyCounter==1){
                enemyCounter=0;
            }else {
                enemyCounter++;
            }
        }
    }
}