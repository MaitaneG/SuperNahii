package com.example.supernaaahigame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.supernaaahigame.R;

public class Menua extends AppCompatActivity {

    private ImageButton hasiJokua;
    private ImageButton bolumena;
    private ImageView tituloa;
    private boolean piztuta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menua);
        hasieratu();
    }

    private void hasieratu() {
        tituloa = findViewById(R.id.imageView);
        hasiJokua = findViewById(R.id.imageButtonHasiJokua);
        bolumena = findViewById(R.id.imageButtonBolumena);

        hasiJokua.setOnClickListener(this::jokuaHasi);
        bolumena.setOnClickListener(this::musikaPiztuEdoItzali);

        Animation anT = AnimationUtils.loadAnimation(this, R.anim.tituloa_atera);
        tituloa.startAnimation(anT);

        Animation anB = AnimationUtils.loadAnimation(this, R.anim.botoia_atera);
        hasiJokua.startAnimation(anB);

        piztuta = true;
    }

    private void musikaPiztuEdoItzali(View view) {
        if (piztuta) {
            view.setBackgroundResource(R.drawable.musika_kenduta);
            piztuta = false;
        } else {
            view.setBackgroundResource(R.drawable.musika_jarrita);
            piztuta = true;
        }
    }


    private void jokuaHasi(View view) {
        Intent myIntent = new Intent(Menua.this, Login.class);
        startActivity(myIntent);
    }
}