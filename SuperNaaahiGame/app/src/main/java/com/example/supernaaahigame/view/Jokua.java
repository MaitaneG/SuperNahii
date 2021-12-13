package com.example.supernaaahigame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.supernaaahigame.R;

public class Jokua extends AppCompatActivity {

    private ImageButton igoBotoia;
    private ImageButton jaitsiBotoia;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // new JokuaView(this)
        setContentView(R.layout.activity_jokua);

        //Botoiak kargatu
        igoBotoia=findViewById(R.id.imageButtonIgo);
        jaitsiBotoia=findViewById(R.id.imageButtonJaitsi);
         view = new JokuaView(this);
    }
}