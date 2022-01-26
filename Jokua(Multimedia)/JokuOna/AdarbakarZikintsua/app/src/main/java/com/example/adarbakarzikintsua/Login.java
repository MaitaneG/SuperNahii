package com.example.adarbakarzikintsua;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity {

    public static Connect con;
    private EditText user;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        con=new Connect(openOrCreateDatabase("scores", Context.MODE_PRIVATE, null));

        user=findViewById(R.id.txtErabiltzailea);
        pass=findViewById(R.id.txtPasahitza);

        findViewById(R.id.btn_login).setOnClickListener(this::login);
        findViewById(R.id.btn_login2).setOnClickListener(this::noLogin);

    }

    public void login(View v){

        if (checkUser()) {
            if(checkPass()){
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this,"Pasahitza okerra sartu duzu",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"Sartu duzun erabiltzailea ez da aurkitu",Toast.LENGTH_SHORT).show();
        }

    }

    public void noLogin(View v){
        Connect.jokalaria=new User(0,"Jokalaria",0,"","");
        Intent intent = new Intent(Login.this, MainActivity.class);
        startActivity(intent);
    }

    public boolean checkUser(){

        for(User u:Connect.users){
            if(u.getIzena().equals(user.getText().toString())){
                Connect.jokalaria=u;
                return true;
            }
        }

        return false;
    }

    public boolean checkPass(){
        return pass.getText().toString().equals("Admin123");
    }

}