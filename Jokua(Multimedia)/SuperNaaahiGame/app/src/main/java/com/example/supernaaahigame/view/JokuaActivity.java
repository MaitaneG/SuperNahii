package com.example.supernaaahigame.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.supernaaahigame.konexioa.Konexioa;
import com.example.supernaaahigame.model.Puntuazioa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class JokuaActivity extends AppCompatActivity {

    private JokuaView jokuaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);

        jokuaView = new JokuaView(this,point.x,point.y);


        Konexioa kon=new Konexioa();
        kon.bidaliMezua(new Puntuazioa(Konexioa.actualUser.getId(),Konexioa.actualUser.getName(),240, LocalDateTime.now()));
        kon.bidaliMezua(new Puntuazioa(Konexioa.actualUser.getId(),Konexioa.actualUser.getName(),280, LocalDateTime.now()));
        setContentView(jokuaView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        jokuaView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        jokuaView.resume();
    }
}