package com.example.supernaaahigame;

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

public class MenuaActivity extends AppCompatActivity {

    private ImageButton hasiJokua;
    private ImageView tituloa;
    private ImageButton logIn;

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

        SQLiteDatabase db = openOrCreateDatabase("nireDiskak", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS nireDiskak(taldea VARCHAR, diska VARCHAR);");
    }


    private void jokuaHasi(View view) {
        Toast.makeText(MenuaActivity.this, "Hola", Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(MenuaActivity.this, Jokua.class);

        startActivity(myIntent);
    }
}