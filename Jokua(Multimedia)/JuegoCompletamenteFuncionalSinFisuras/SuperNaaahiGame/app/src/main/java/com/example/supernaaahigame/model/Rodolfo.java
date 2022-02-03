package com.example.supernaaahigame.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.example.supernaaahigame.view.GameView;
import com.example.supernaaahigame.view.MainActivity;


public class Rodolfo {

    Bitmap[] rodolfoBitmap;
    int x;
    int y;
    public int width;
    public int height;
    int rodolfoCounter = 0;
    Rect collisionRect;

    public Rodolfo(Bitmap[] rodolfoBitmap) {
        this.rodolfoBitmap = rodolfoBitmap;
        width = (int) ((rodolfoBitmap[0].getWidth() / 4) * MainActivity.pointX);
        height = (int) ((rodolfoBitmap[0].getHeight() / 4) * MainActivity.pointY);

        y = GameView.screenY - this.height;
        x = 50;
        collisionRect = new Rect(width/4+1, y+1, x + width-1, y + height-1);


    }

    public void update(){
        collisionRect = new Rect(width/4+1, y+1, x + width-1, y + height-1);

            if (Rect.intersects(GameView.demonico.collisionRect, collisionRect) && !GameView.debug) {
                GameView.isGameOver = true;
                return;
            }

            if (Rect.intersects(GameView.carrey.collisionRect, collisionRect) && !GameView.debug) {
                GameView.isGameOver = true;
                return;
            }

            if (GameView.isJump) {
                y = GameView.screenY/5;
            }   else if (GameView.isTocandoFondo) {
                y = GameView.screenY - this.height + 110;
            } else {
                y = GameView.screenY - this.height;
            }


    }
    public void draw(Canvas canvas){

            if (GameView.debug)
                canvas.drawRect(collisionRect, GameView.pu);

            if (GameView.isJump) {
                canvas.drawBitmap(rodolfoBitmap[2], x, y, GameView.paint);
            } else if (GameView.isTocandoFondo) {
                canvas.drawBitmap(rodolfoBitmap[3], x, y, GameView.paint);
            } else if (rodolfoCounter < 1){
                rodolfoCounter++;
                canvas.drawBitmap(rodolfoBitmap[rodolfoCounter], x, y, GameView.paint);
            }else{
                rodolfoCounter = 0;
                canvas.drawBitmap(rodolfoBitmap[rodolfoCounter], x, y, GameView.paint);
            }
    }
}
