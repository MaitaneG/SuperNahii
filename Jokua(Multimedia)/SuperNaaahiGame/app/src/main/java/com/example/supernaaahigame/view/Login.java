package com.example.supernaaahigame.view;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supernaaahigame.R;
import com.example.supernaaahigame.konexioa.Konexioa;
import com.example.supernaaahigame.model.User;

import java.util.ArrayList;
//import com.example.supernaaahigame.db.Konektatu;

/**
 * Login Layout-aren klasea
 */
public class Login extends AppCompatActivity {
    /**
     * Atributoak
     */
    // Botoia
    private ImageButton loginBotoia;
    // Idazteko labelak
    private EditText emaila, pasahitza;
    // Konexioa
    //Konektatu konexioa;
    private static boolean login = false;
    // Intent-a
    private Intent intent;

    public static SQLiteDatabase db;

    Konexioa konexioa;



    /**
     * Layout-a sortzen denean
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        db = openOrCreateDatabase("Txapelketa", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS Txapelketa(id INTEGER,email VARCHAR, password VARCHAR);");
        hasieratu();

        konexioa = new Konexioa();
        konexioa.erabiltzaileakLortu();

    }

    /**
     * Konponente guztiak hasieratu
     */
    private void hasieratu() {
        // Labelak

        emaila = findViewById(R.id.editTextEmailLogin);
        pasahitza = findViewById(R.id.editPasswordLogin);
        // Jolasa hasteko botoia
        loginBotoia = findViewById(R.id.loginbtn);
        // Botoiari listenerra jarri

        loginBotoia.setOnClickListener(this::botoiaSakatu);





    }
    /**
     * Logina balidatu eta jokua hasi
     * @param view
     */
    private void botoiaSakatu(View view) {
        String user=emaila.getText().toString();
        String pass=pasahitza.getText().toString();
        User us=new User(user,pass);
        if(us.getEmail().equals("")&& us.getPass().equals("")){
            Toast.makeText(this, "Eremu guztiak bete behar dira", Toast.LENGTH_SHORT).show();
        } else {
            if(konexioa.login(us)){
                Toast.makeText(this, "Logeatu zara", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(Login.this, JokuaActivity.class);
                startActivity(i);

            }
            else{
                Toast.makeText(this, "Ez zara logeatu ", Toast.LENGTH_SHORT).show();
            }
        }

    }
 



}
