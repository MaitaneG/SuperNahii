package com.example.supernaaahigame.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.supernaaahigame.db.Konektatu;
import com.example.supernaaahigame.R;

public class Login extends AppCompatActivity {
    Button loginBotoia;
    EditText emaila,pasahitza;  
    Konektatu konexioa;
    static boolean login = false;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        konexioa=new Konektatu();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emaila=findViewById(R.id.editTextEmailLogin);
        pasahitza=findViewById(R.id.editPasswordLogin);
        loginBotoia=findViewById(R.id.loginbtn);
        loginBotoia.setOnClickListener(this::botoiaSakatu);
    }

    public void botoiaSakatu(View view) {


            if (konexioa.login(emaila.getText().toString(), pasahitza.getText().toString())) {
                login = true;
                intent=new Intent(Login.this, Jokua.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Ez zara salmenten arduraduna.", Toast.LENGTH_SHORT).show();
            }

    }

}
