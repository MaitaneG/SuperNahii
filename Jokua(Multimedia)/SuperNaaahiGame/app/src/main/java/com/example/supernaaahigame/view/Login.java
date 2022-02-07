package com.example.supernaaahigame.view;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supernaaahigame.R;
import com.example.supernaaahigame.konexioa.Konexioa;
import com.example.supernaaahigame.model.User;
//import com.example.supernaaahigame.db.Konektatu;

/**
 * Login Layout-aren klasea
 */
public class Login extends AppCompatActivity {
    private ImageButton loginBotoia;
    private EditText emaila, pasahitza;
    private static boolean login = false;
    private Intent intent;
    public static SQLiteDatabase db;
    private Konexioa konexioa;


    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        hasieratu();
    }

    /**
     * Konponente guztiak hasieratu
     */
    private void hasieratu() {
        // EditText
        emaila = findViewById(R.id.editTextEmailLogin);
        pasahitza = findViewById(R.id.editPasswordLogin);
        // ImageButton
        loginBotoia = findViewById(R.id.loginbtn);
        // OnClickListener
        loginBotoia.setOnClickListener(this::botoiaSakatu);
        // Datubasea
        db = openOrCreateDatabase("Txapelketa", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Erabiltzaileak(id INTEGER PRIMARY KEY AUTOINCREMENT,izena VARCHAR,email VARCHAR, password VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS Puntuazioak(id INTEGER PRIMARY KEY AUTOINCREMENT, jokalariaId INT,jokalaria VARCHAR,puntuak int, data DATETIME);");
        // Konexioa
        konexioa = new Konexioa();
        konexioa.erabiltzaileakLortu();
        konexioa.bidaliPuntuazioak();
    }

    /**
     * Logina balidatu eta jokua hasi
     *
     * @param view
     */
    private void botoiaSakatu(View view) {
        String user = emaila.getText().toString();
        String pass = pasahitza.getText().toString();
        User us = new User(user, pass);
        // Gakoak hutsik badaude
        if (us.getEmail().equals("") && us.getPass().equals("")) {
            Toast.makeText(this, "Eremu guztiak bete behar dira", Toast.LENGTH_SHORT).show();
        } else {
            // Konexioa ondo egin bada
            if (konexioa.login(us)) {
                Toast.makeText(this, "Logeatu zara", Toast.LENGTH_SHORT).show();

                // Hasiera pantailara doia
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            } else {
                Toast.makeText(this, "Ez zara logeatu ", Toast.LENGTH_SHORT).show();
            }
        }
    }
}