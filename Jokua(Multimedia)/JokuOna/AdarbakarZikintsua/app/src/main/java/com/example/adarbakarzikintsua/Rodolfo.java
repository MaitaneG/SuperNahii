package com.example.adarbakarzikintsua;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import static com.example.adarbakarzikintsua.MainActivity.pointX;
import static com.example.adarbakarzikintsua.MainActivity.pointY;

public class Rodolfo {

    Bitmap[] rodolfoBitmap;
    int x, y, width, height;
    int unicornioCounter = 0;
    Rect collisionRect;

    Rodolfo(Bitmap[] rodolfoBitmap) {
        this.rodolfoBitmap = rodolfoBitmap;
        width = (int) ((rodolfoBitmap[0].getWidth() / 4) * pointX);
        height = (int) ((rodolfoBitmap[0].getHeight() / 4) * pointY);

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


    }
    public void draw(Canvas canvas){

            canvas.drawBitmap(rodolfoBitmap[unicornioCounter], x, y, GameView.paint);
            if (GameView.debug)
                canvas.drawRect(collisionRect, GameView.pu);
            if(unicornioCounter < 1){
                unicornioCounter++;
            }else{
                unicornioCounter = 0;
            }
    }
}
