package com.example.supernaaahigame.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supernaaahigame.R;


public class PerdisteActivity extends AppCompatActivity {
    private ImageButton atzeraBotoia;
    private ImageButton pairatuBotoia;
    private TextView puntuazioaLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdiste);

        hasieratu();
    }

    private void hasieratu() {
        atzeraBotoia = findViewById(R.id.imageButtonAtzera);
        pairatuBotoia = findViewById(R.id.imageButtonPairatu);
        puntuazioaLabel = findViewById(R.id.textViewPuntuak);

        atzeraBotoia.setOnClickListener(this::atzeraJoan);
        pairatuBotoia.setOnClickListener(this::berriroJolastu);

        MainActivity.hasierakoMusika.stop();
        MainActivity.piztuta=false;

        puntuazioaLabel.setText("Puntuak: "+String.valueOf(GameActivity.puntuak));
    }

    private void berriroJolastu(View view) {
        Intent intent = new Intent(PerdisteActivity.this, GameActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void atzeraJoan(View view) {
        Intent intent = new Intent(PerdisteActivity.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
