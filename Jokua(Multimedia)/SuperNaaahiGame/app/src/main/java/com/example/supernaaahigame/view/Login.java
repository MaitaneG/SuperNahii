package com.example.supernaaahigame.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supernaaahigame.R;
import com.example.supernaaahigame.konexioa.db.MyDbHelper;
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
    MyDbHelper helper;

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
        // Labelak
        emaila = findViewById(R.id.editTextEmailLogin);
        pasahitza = findViewById(R.id.editPasswordLogin);
        // Jolasa hasteko botoia
        loginBotoia = findViewById(R.id.loginbtn);
        // Botoiari listenerra jarri
        loginBotoia.setOnClickListener(this::botoiaSakatu);
        //Konexioa egiten da
       // konexioa = new Konektatu();
    }

    /**
     * Logina balidatu eta jokua hasi
     * @param view
     */
//    public void botoiaSakatu(View view) {
//        // Gakoak hutsik badaude
//        if (emaila.getText().toString().equals("") || pasahitza.getText().toString().equals("")) {
//            Toast.makeText(Login.this, "Gakoak bete behar dituzu.", Toast.LENGTH_SHORT).show();
//        } else {
//            // Konexioa ondo egin bada eta emaila eta pasahitza ondo egin bada
//            if (konexioa.login(emaila.getText().toString(), pasahitza.getText().toString())) {
//                login = true;
//                intent = new Intent(Login.this, Jokua.class);
//                startActivity(intent);
//            } else {
//                Toast.makeText(getApplicationContext(), "Ez zara enpresako langilea.", Toast.LENGTH_SHORT).show();
//                login = true;
//                intent = new Intent(Login.this, Jokua.class);
//                startActivity(intent);
//            }
//        }
//    }
    public void botoiaSakatu(View view) {




    }

}
