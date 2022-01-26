package com.example.adarbakarzikintsua;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class PointsForm extends AppCompatActivity {

    private SQLiteDatabase db;
    private TextView izena;
    private TextView puntuazioa;
    private TextView highScore;
    private TextView max_label;
    private List<Puntuazioa> puntuazioak = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.points_form);

        puntuazioa = findViewById(R.id.txt_points);
        izena = findViewById(R.id.txt_izena);
        highScore = findViewById(R.id.txt_highscore);
        max_label = findViewById(R.id.label_max);

        setJokalariIzena();

        if (Connect.highScore > 0) {
            highScore.setText(Integer.toString(Connect.highScore));
            highScore.setVisibility(View.VISIBLE);
            max_label.setVisibility(View.VISIBLE);
        } else {
            highScore.setVisibility(View.INVISIBLE);
            max_label.setVisibility(View.INVISIBLE);
        }

        puntuazioa.setText(Integer.toString(GameActivity.puntuak));

        findViewById(R.id.btn_ezGorde).setOnClickListener(view -> startActivity(new Intent(PointsForm.this, MainActivity.class)));

        findViewById(R.id.btn_gorde).setOnClickListener(this::gordePuntuazioa);


    }

    public void gordePuntuazioa(View v) {
        Puntuazioa p = new Puntuazioa(izena.getText().toString(), Integer.parseInt(puntuazioa.getText().toString()));
        puntuazioak.add(p);
        db = openOrCreateDatabase("scores", Context.MODE_PRIVATE, null);
       /* if(!izena.getText().toString().equals("")) {
            Puntuazioa p=new Puntuazioa(izena.getText().toString(),Integer.parseInt(puntuazioa.getText().toString()));
            puntuazioak.add(p);
            if(!Connect.status) {
                db.execSQL("CREATE TABLE IF NOT EXISTS scores(puntuazioa INT);");
                String insert_query = "INSERT INTO scores VALUES (" + p.getPuntuak()+")";
                db.execSQL(insert_query);
                Toast.makeText(this, "Puntuazioa lokalean gorde da!", Toast.LENGTH_LONG).show();
            } else {
                irakurriLokala(puntuazioak);
                Connect.igoPuntuazioak(puntuazioak);
                db.execSQL("DELETE FROM scores;");
                Toast.makeText(this, "Puntuazioa igo da!", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(PointsForm.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Izena ezin da hutsik egon!", Toast.LENGTH_LONG).show();
        }*/
        if(Connect.status){
            bidaliZerbitzarira();
            Toast.makeText(this, "Puntuazioa igo da!", Toast.LENGTH_LONG).show();
        } else {
            db.execSQL("CREATE TABLE IF NOT EXISTS scores(puntuazioa INT);");
            String insert_query = "INSERT INTO scores VALUES (" + p.getPuntuak()+")";
            db.execSQL(insert_query);
            Toast.makeText(this, "Puntuazioa lokalean gorde da!", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(PointsForm.this, MainActivity.class);
        startActivity(intent);
    }

    public void irakurriLokala() {
        Cursor cursor = db.rawQuery("SELECT * FROM scores", null);
        while (cursor.moveToNext()) {
            puntuazioak.add(new Puntuazioa(izena.getText().toString(), cursor.getInt(0)));
            Log.d("odoo", "punt: " + cursor.getInt(0));
        }
    }

    public void setJokalariIzena() {
        String[] email = Connect.jokalaria.getIzena().split("@");
        izena.setText(email[0]);
    }

    public void bidaliZerbitzarira() {
        irakurriLokala();
        Thread thread = new Thread(() -> {
            String host = "192.168.65.3";
            int port = 6000;

            //Socket-a ireki
            Socket bezeroa = null;
            try {
                bezeroa = new Socket(host, port);

                System.out.println("Socket TCP BEZEROA martxan... ");
                // Bezeroaren irteera fluxua zerbitzariari mezuak bidaltzeko
                OutputStream os = bezeroa.getOutputStream();
                PrintWriter pwos = new PrintWriter(os, true);

                // Bezeroaren sarrera fluxua zerbitzaritik mezuak irakurtzeko
                InputStream is = bezeroa.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String jasotakoTestua = "";
                String bidaltzekoTestua = izena.getText().toString() + "," + Connect.jokalaria.getId()+ "," + Connect.jokalaria.getDepartment()+ "," + Connect.jokalaria.getBirthday()+","+Connect.jokalaria.getDep_name();

                for(Puntuazioa p:puntuazioak){
                    bidaltzekoTestua+=","+p.getPuntuak();
                }
                pwos.println(bidaltzekoTestua); // Zerbitzariari bidaltzen diogu
                System.out.println(bidaltzekoTestua);

                pwos.println("end");
                //Fluxuak eta socket-ak itxi
                System.out.println("Konexioak isten...");
                pwos.close();
                os.close();
                bezeroa.close();
                System.out.println("Socket TCP BEZEROA itzalita. Agur!");
                db.execSQL("DELETE FROM scores;");
            } catch (IOException e) {
                //e.printStackTrace();
            }
        });
        thread.start();

    }

}