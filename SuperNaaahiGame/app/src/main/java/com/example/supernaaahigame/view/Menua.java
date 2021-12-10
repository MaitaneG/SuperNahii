package com.example.supernaaahigame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.supernaaahigame.R;

/**
 * Menua Layout-aren klasea
 */
public class Menua extends AppCompatActivity {

    /**
     * Atributoak
     */
    // Botoiak
    private ImageButton hasiJokua;
    private ImageButton bolumena;
    private ImageView tituloa;
    // Musika eta musika piztuta dagoen
    private MediaPlayer hasierakoMusika;
    private boolean piztuta;

    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menua);
        hasieratu(); // Konponenteak hasieratu
    }

    /**
     * Konponente guztiak hasieratu
     */
    private void hasieratu() {
        // Titulua
        tituloa = findViewById(R.id.imageView);
        // Hasteko botoia
        hasiJokua = findViewById(R.id.imageButtonHasiJokua);
        // Musika kentzeko edo berriro jartzeko botoia
        bolumena = findViewById(R.id.imageButtonBolumena);

        // Botoiei listenerrerrak jarri
        hasiJokua.setOnClickListener(this::jokuaHasi);
        bolumena.setOnClickListener(this::musikaPiztuEdoItzali);

        // Tituluari animazioa jartzen du
        Animation anT = AnimationUtils.loadAnimation(this, R.anim.tituloa_atera);
        tituloa.startAnimation(anT);

        // Hasteko botoiari animazioa jartzen du
        Animation anB = AnimationUtils.loadAnimation(this, R.anim.botoia_atera);
        hasiJokua.startAnimation(anB);

        // Abestia zehazten da
        hasierakoMusika = MediaPlayer.create(this, R.raw.jingle_bell_rock_remix);

        // Musika ez badago jarrita, abestia hasten da
        if (!hasierakoMusika.isPlaying()) {
            hasierakoMusika.start();
        }

        piztuta = true;
    }

    /**
     * Musika itzaltzeko edo pizteko botoian klikatzean, musika piztu edo itzaltzen du
     *
     * @param view
     */
    private void musikaPiztuEdoItzali(View view) {
        // Piztuta badago, itzaltzen da
        if (piztuta) {
            view.setBackgroundResource(R.drawable.musika_kenduta);
            hasierakoMusika.stop();
            piztuta = false;
            // Ez badago piztuta pizten du
        } else {
            view.setBackgroundResource(R.drawable.musika_jarrita);
            hasierakoMusika = MediaPlayer.create(this, R.raw.jingle_bell_rock_remix);
            hasierakoMusika.start();
            piztuta = true;
        }
    }

    /**
     * Loginera joango daS
     * @param view
     */
    private void jokuaHasi(View view) {
        Intent myIntent = new Intent(Menua.this, Login.class);
        startActivity(myIntent);
    }
}