package com.example.supernaaahigame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
    private ImageView tituloa;
    private ImageButton logIn;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menua);
        hasieratu();
    }

    private void hasieratu() {
        tituloa = findViewById(R.id.imageView);
        hasiJokua = findViewById(R.id.imageButtonHasiJokua);
        logIn = findViewById(R.id.imageButtonErabiltzailea);

        hasiJokua.setOnClickListener(this::jokuaHasi);

        Animation anT = AnimationUtils.loadAnimation(this, R.anim.tituloa_atera);
        tituloa.startAnimation(anT);

        Animation anB = AnimationUtils.loadAnimation(this, R.anim.botoia_atera);
        hasiJokua.startAnimation(anB);

    }


    private void jokuaHasi(View view) {
        Toast.makeText(Menua.this, "Hola", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(Menua.this, Login.class);
        startActivity(myIntent);
    }
}