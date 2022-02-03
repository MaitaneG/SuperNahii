package com.example.supernaaahigame.konexioa;

import android.database.Cursor;
import android.util.Log;

import com.example.supernaaahigame.model.Puntuazioa;
import com.example.supernaaahigame.model.User;
import com.example.supernaaahigame.view.Login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Konexioa extends Thread {
    //    private final String ip = "192.168.65.187";
    private final String ip = "192.168.65.187";
    private final int puerto = 9000;
    private boolean konektatuta;
    private ArrayList<User> users;
    public static User actualUser;


    public boolean konexioaKonprobatu(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Socket-a sortu
                    Socket sk = new Socket(ip, puerto);
                    BufferedReader entrada = new BufferedReader(new
                            InputStreamReader(sk.getInputStream()));

                    PrintWriter salida = new PrintWriter(
                            new OutputStreamWriter(sk.getOutputStream()), true);

                    salida.println("Hor zaude?");

                    if(entrada.readLine() != null){
                        konektatuta = true;
                    }

                }catch (Exception ex) {
                    ex.printStackTrace();
                    System.err.println("Konexioa gaizki egin da");
                    konektatuta = false;
                }
            }
        });
        return konektatuta;
    }

    public boolean bidaliPuntuzioak(Puntuazioa puntuazioa) {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // Socket-a sortu
                            Socket sk = new Socket(ip, puerto);

                            // Irteera bueltatzeko objetua
                            PrintWriter salida = new PrintWriter(
                                    new OutputStreamWriter(sk.getOutputStream()), true);

                            salida.println(puntuazioa.toString());
                            salida.println("bukatu");

                            sk.close();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            System.err.println("Konexioa gaizki egin da");
                            konektatuta = false;
                        }
                    }
                }
        ).start();
        return konektatuta;
    }

    public ArrayList<User> erabiltzaileakLortu() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        users = new ArrayList<>();
                        try {
                            Socket sk = new Socket(ip, puerto);
                            BufferedReader entrada = new BufferedReader(new
                                    InputStreamReader(sk.getInputStream()));

                            PrintWriter salida = new PrintWriter(
                                    new OutputStreamWriter(sk.getOutputStream()), true);
                            salida.println("Erabiltzaileak bidali");

                            String borrau="DELETE FROM Erabiltzaileak";
                            Login.db.execSQL(borrau);
                            String jaso="";
                            while ((jaso=entrada.readLine()) != null) {
                                Log.d("entrada",jaso);
                                String[] erregistroak = jaso.split(";");
                                for (int i = 0; i < erregistroak.length; i++) {
                                    String[] parts = erregistroak[i].split(",");
                                    users.add(new User(Integer.parseInt((parts[0])),(parts[1]),(parts[2]), parts[3]));
                                    String insert_query = "INSERT INTO Erabiltzaileak(id,izena,email,password) VALUES ("+users.get(i).getId()+",'"+ users.get(i).getName() + "', '" + users.get(i).getEmail() +  "', '" + users.get(i).getPass() + "')";
                                    Login.db.execSQL(insert_query);

                                }

                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                }).start();

        return users;
    }

    public boolean login(User u) {

        Cursor c = Login.db.rawQuery("select * from Erabiltzaileak where email='" + u.getEmail() + "' and password='" + u.getPass() + "';", null);
        while(c.moveToNext()){
            User a=new User(c.getInt(0),c.getString(1),c.getString(2),c.getString(3));
            actualUser=a;
            return true;
        }
        return false;

    }


}
