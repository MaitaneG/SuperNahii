package com.example.supernaaahigame.view;

import android.content.Intent;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.supernaaahigame.R;

/**
 * MainActivity-aren klasea
 */
public class MainActivity extends AppCompatActivity {

    private ImageView tituloa;
    private ImageButton hasiJokua;
    public static float pointX, pointY = 0;
    public static MediaPlayer hasierakoMusika;
    public static boolean piztuta;

    /**
     * MainActivity-aren konstruktorea
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Pantailaren tamaina lortu eta Point objektuan gorde
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        pointX = 1920f / point.x;
        pointY = 1080f / point.y;

        // ImageView
        tituloa = findViewById(R.id.imageView);
        // ImageButton
        hasiJokua = findViewById(R.id.imageButtonHasiJokua);
        // Animation
        Animation anT = AnimationUtils.loadAnimation(this, R.anim.tituloa_atera);
        tituloa.startAnimation(anT);
        Animation anB = AnimationUtils.loadAnimation(this, R.anim.botoia_atera);
        hasiJokua.startAnimation(anB);
        // OnClickListener
        hasiJokua.setOnClickListener(this::jokatu);
        // Abestia hasieratzen da
        hasierakoMusika = MediaPlayer.create(this, R.raw.jingle_bell_rock_remix);

        // Musika ez badago jarrita, abestia hasten da
//        if (piztuta) {
//            view.setBackgroundResource(R.drawable.musicaoff);
//            hasierakoMusika.pause();
//            piztuta = false;
//            // Ez badago piztuta pizten du
//        } else {
//            view.setBackgroundResource(R.drawable.musika_jarrita);
//            hasierakoMusika = MediaPlayer.create(this, R.raw.jingle_bell_rock_remix);
//            hasierakoMusika.start();
//            piztuta = true;
//        }

        // Musika ez badago piztuta, musika jarri
        if (!hasierakoMusika.isPlaying()) {
            hasierakoMusika.setVolume(0.5f, 0.5f);
            hasierakoMusika.start();
        }

        piztuta = true;
    }

    // GameActivity-ra doa
    public void jokatu(View v) {
        Intent intent = new Intent(MainActivity.this, GameActivity.class);
        startActivity(intent);
    }
}