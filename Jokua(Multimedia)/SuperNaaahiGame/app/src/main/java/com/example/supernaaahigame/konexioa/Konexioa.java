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
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class Konexioa extends Thread {
    //    private final String ip = "192.168.65.187";
    private final String ip = "192.168.65.187";
    private final int puerto = 9000;
    private boolean konektatuta;
    private ArrayList<User> users;
    public static User actualUser;

    public boolean bidaliPuntuzioa(Puntuazioa puntuazioa) {
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
                            ArrayList<Puntuazioa>puntuazioas=new ArrayList<>();
                            Cursor c = Login.db.rawQuery("SELECT * FROM Puntuazioak ;", null);
                            while(c.moveToNext()){
                                Puntuazioa p=new Puntuazioa( new User(c.getInt(0),c.getString(1)),c.getInt(3),c.getString(4));
                                puntuazioas.add(p);
                            }
                            String borrau="DELETE FROM Puntuazioak";
                            Login.db.execSQL(borrau);
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

    public void bidaliPuntuazioak(){
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Socket sk = new Socket(ip, puerto);
                    PrintWriter salida = new PrintWriter(
                            new OutputStreamWriter(sk.getOutputStream()), true);

                    ArrayList<Puntuazioa>puntuazioas=new ArrayList<>();
                    String puntuazioString="";
                    int i=0;
                    Cursor c = Login.db.rawQuery("SELECT * FROM Puntuazioak ;", null);
                    while(c.moveToNext()){
                        Puntuazioa p=new Puntuazioa( new User(c.getInt(1),c.getString(2)),c.getInt(3),c.getString(4));
                        puntuazioas.add(p);
                        puntuazioString=puntuazioString+puntuazioas.get(i).toString();
                        i++;
                    }

                    salida.println(puntuazioString);
                    String borrau="DELETE FROM Puntuazioak";
                    Login.db.execSQL(borrau);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }

    public static boolean insertSqlitePuntuazioa(Puntuazioa puntuazioa){
        try{
            String insert_query = "INSERT INTO Puntuazioak(jokalariaId,jokalaria,puntuak,data) VALUES ("+puntuazioa.getJokalari().getId()+",'"+ puntuazioa.getJokalari().getName() + "', " + puntuazioa.getPuntuak() + ", '" + puntuazioa.getData() + "')";
            Login.db.execSQL(insert_query);
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
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
