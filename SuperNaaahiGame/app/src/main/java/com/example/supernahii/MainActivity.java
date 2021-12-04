package com.example.supernahii;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton hasiJokua;
    private ImageView tituloa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hasieratu();
    }

    private void hasieratu() {
        tituloa=findViewById(R.id.imageView);
        hasiJokua=findViewById(R.id.imageButtonHasiJokua);
        hasiJokua.setOnClickListener(this::jokuaHasi);

        Animation anT = AnimationUtils.loadAnimation(this, R.anim.tituloa_atera);
        tituloa.startAnimation(anT);

        Animation anB = AnimationUtils.loadAnimation(this, R.anim.botoia_atera);
        hasiJokua.startAnimation(anB);

    }

    private void jokuaHasi(View view) {
        Toast.makeText(MainActivity.this,"Hola",Toast.LENGTH_SHORT).show();
    }
}