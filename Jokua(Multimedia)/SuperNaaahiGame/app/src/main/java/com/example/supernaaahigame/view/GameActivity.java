package com.example.supernaaahigame.view;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.supernaaahigame.R;

/**
 * Jolasaren activity-a
 * GameView bista bistaratzen du
 */
public class GameActivity extends AppCompatActivity {

    public static MediaPlayer naaahiMusika;
    public static MediaPlayer aiiiMusika;
    // public static MediaPlayer hipoMusika;
    //public static MediaPlayer grinchMusika;
    private GameView gameView;
    public static int puntuak = 0;

    /**
     * GameActivity-aren konstruktorea
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        // Pantailaren tamaina lortu eta Point objektuan gorde
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        // GameView objektua sortu
        gameView = new GameView(this, point.x, point.y);

        // Jokuaren soinuak hasieratu
        aiiiMusika = MediaPlayer.create(this, R.raw.aiiiii);
        naaahiMusika = MediaPlayer.create(this, R.raw.naaahi);
        //hipoMusika=MediaPlayer.create(this, R.raw.hipo);
        //grinchMusika=MediaPlayer.create(this, R.raw.grinch);

        // Musika ez badago, musika pizten du
        if (!MainActivity.piztuta) {
            MainActivity.hasierakoMusika = MediaPlayer.create(this, R.raw.jingle_bell_rock_remix);
            MainActivity.hasierakoMusika.setVolume(0.5f, 0.5f);
            MainActivity.hasierakoMusika.start();
        }

        setContentView(gameView);
    }

    /**
     * Jokua pausatzen denean
     */
    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    /**
     * Jokua berrezkuaratzen denean
     */
    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}
