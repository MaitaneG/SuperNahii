package com.example.supernaaahigame.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supernaaahigame.R;
import com.example.supernaaahigame.konexioa.Konexioa;
import com.example.supernaaahigame.model.Puntuazioa;
import com.example.supernaaahigame.model.User;

import java.time.LocalDateTime;

/**
 * Game Over pantailaren activity-a
 */
public class PerdisteActivity extends AppCompatActivity {
    private ImageButton atzeraBotoia;
    private ImageButton pairatuBotoia;
    private TextView puntuazioaLabel;

    /**
     * PerdisteActivity-aren konstruktorea
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perdiste);

        hasieratu();
    }

    /**
     * Elementuak hasieratu
     */
    private void hasieratu() {
        // ImageButton
        atzeraBotoia = findViewById(R.id.imageButtonAtzera);
        pairatuBotoia = findViewById(R.id.imageButtonPairatu);
        // TextView
        puntuazioaLabel = findViewById(R.id.textViewPuntuak);
        // OnClickListener
        atzeraBotoia.setOnClickListener(this::atzeraJoan);
        pairatuBotoia.setOnClickListener(this::berriroJolastu);

        // Musika itzali
        MainActivity.hasierakoMusika.stop();

        // Puntuazioa bistaratu
        puntuazioaLabel.setText("Puntuak: " + String.valueOf(GameActivity.puntuak));
        // Puntuazioak bidali
        puntuazioakBidali();
    }

    /**
     * Puntuazioak bidali zerbitzariara
     */
    private void puntuazioakBidali() {
        Konexioa konexioa = new Konexioa();
        Puntuazioa puntuazioa = new Puntuazioa(Konexioa.actualUser, GameActivity.puntuak, String.valueOf(LocalDateTime.now()));

        // Ezin bada konektatu, SQLite-n puntuazioa gehituko da
        if (!konexioa.bidaliPuntuzioa(puntuazioa)) {
            konexioa.insertSqlitePuntuazioa(puntuazioa);
        }
    }

    /**
     * GameActivity-ra doa
     *
     * @param view
     */
    private void berriroJolastu(View view) {
        Intent intent = new Intent(PerdisteActivity.this, GameActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * LoginActivity-ra doa
     *
     * @param view
     */
    private void atzeraJoan(View view) {
        Intent intent = new Intent(PerdisteActivity.this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
