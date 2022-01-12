package com.example.supernaaahigame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        setContentView(new JokuaView(this, point.x,point.y));
    }
}