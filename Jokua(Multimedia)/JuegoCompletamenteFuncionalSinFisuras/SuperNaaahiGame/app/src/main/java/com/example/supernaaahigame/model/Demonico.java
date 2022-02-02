package com.example.supernaaahigame.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.supernaaahigame.view.GameView;
import com.example.supernaaahigame.view.MainActivity;


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

    public Demonico(Bitmap[] enemyBitmap) {
        this.enemyBitmap = enemyBitmap;
        width = (int) ((enemyBitmap[0].getWidth() / 8) * MainActivity.pointX);
        height = (int) ((enemyBitmap[0].getHeight() / 8) * MainActivity.pointY);
        y = GameView.screenY/(int)2.5;

        collisionRect = new Rect(x, y, x + width, y + height);

    }

    public static void update(){        

        //Enemyen abiadura denborarekin azkartzea
        if(GameView.tic % 50 ==0){
            enemy1Speed++;
        }

        GameView.demonico.collisionRect = new Rect(GameView.demonico.x, GameView.demonico.y, GameView.demonico.x + width, GameView.demonico.y + height);
            GameView.demonico.x -= GameView.demonico.speed;
            if ((GameView.demonico.x + width) + GameView.demonico.width <= 0) {
                GameView.demonico.speed = (int) (enemy1Speed * GameView.screenRatioX);
                GameView.demonico.x = GameView.screenX + 5;
                GameView.demonico.y = GameView.screenY - (int)(height * 2.5);
                if(sumaputodemonico){
                    //GameActivity.puntuak++;
                }
                GameView.demonico.morision = false;
                GameView.TurnoEnemigo();
            }
            sumaputodemonico=true;

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