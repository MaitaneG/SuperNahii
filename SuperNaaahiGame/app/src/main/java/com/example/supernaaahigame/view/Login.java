package com.example.supernaaahigame.view;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supernaaahigame.db.Konektatu;
import com.example.supernaaahigame.R;

public class Login extends AppCompatActivity {
    private ImageButton loginBotoia;
    private EditText emaila, pasahitza;
    Konektatu konexioa;
    private static boolean login = false;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        konexioa = new Konektatu();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        hasieratu();
    }

    private void hasieratu() {
        emaila = findViewById(R.id.editTextEmailLogin);
        pasahitza = findViewById(R.id.editPasswordLogin);
        loginBotoia = findViewById(R.id.loginbtn);
        loginBotoia.setOnClickListener(this::botoiaSakatu);
    }

    public void botoiaSakatu(View view) {
        if (emaila.getText().toString().equals("") || pasahitza.getText().toString().equals("")) {
            Toast.makeText(Login.this, "Gakoak bete behar dituzu.", Toast.LENGTH_SHORT).show();
        } else {
            if (konexioa.login(emaila.getText().toString(), pasahitza.getText().toString())) {
                login = true;
                intent = new Intent(Login.this, Jokua.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Ez zara enpresako langilea.", Toast.LENGTH_SHORT).show();
                login = true;
                intent = new Intent(Login.this, Jokua.class);
                startActivity(intent);
            }
        }
    }
}
