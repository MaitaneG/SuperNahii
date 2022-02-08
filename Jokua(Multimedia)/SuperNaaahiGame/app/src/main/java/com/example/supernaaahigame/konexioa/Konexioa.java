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

/**
 * Konexioak kudeatzeko klasea
 */
public class Konexioa extends Thread {
    //    private final String ip = "192.168.65.187";
    private final String ip = "192.168.65.187";
    private final int puerto = 9000;
    private boolean konektatuta;
    private ArrayList<User> users;
    public static User actualUser;

    /**
     * Jolastu den partidaren informazioa Zerbitzarira bidaltzea saiatu
     *
     * @param puntuazioa
     * @return
     */
    public boolean bidaliPuntuzioa(Puntuazioa puntuazioa) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Socket-a sortu
                    Socket sk = new Socket(ip, puerto);

                    // Irteera bueltatzeko objetua
                    PrintWriter salida = new PrintWriter(
                            new OutputStreamWriter(sk.getOutputStream()), true);

                    // Puntuazioaren string bat bidali
                    salida.println(puntuazioa.toString());
                    salida.println("bukatu");

                    // SQLiten dauden Puntuazioa edo puntuazioak ezabatzen ditu
                    String borrau = "DELETE FROM Puntuazioak";
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

    /**
     * SQLiten dauden puntuazioak igo
     */
    public void bidaliPuntuazioak() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Socket-a sortu
                    Socket sk = new Socket(ip, puerto);

                    // Irteera bueltatzeko objetua
                    PrintWriter salida = new PrintWriter(
                            new OutputStreamWriter(sk.getOutputStream()), true);

                    // Puntuazioen string bat sortu SQLite-tik lortutako informazioarekin
                    String puntuazioString = "";
                    Cursor c = Login.db.rawQuery("SELECT * FROM Puntuazioak ;", null);
                    while (c.moveToNext()) {
                        Puntuazioa p = new Puntuazioa(new User(c.getInt(1), c.getString(2)), c.getInt(3), c.getString(4));

                        puntuazioString = puntuazioString + p.toString();
                    }

                    // Puntuazioen string-a bidali
                    salida.println(puntuazioString);

                    // Puntuazioaren informazioa bidali  SQLite-tik
                    String borrau = "DELETE FROM Puntuazioak";
                    Login.db.execSQL(borrau);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * Puntuazioak gehitzen ditu SQLite-n
     *
     * @param puntuazioa
     * @return
     */
    public boolean insertSqlitePuntuazioa(Puntuazioa puntuazioa) {
        try {
            // Puntuazioak gehitu SQLite-n
            String insert_query = "INSERT INTO Puntuazioak(jokalariaId,jokalaria,puntuak,data) VALUES (" + puntuazioa.getJokalari().getId() + ",'" + puntuazioa.getJokalari().getName() + "', " + puntuazioa.getPuntuak() + ", '" + puntuazioa.getData() + "')";
            Login.db.execSQL(insert_query);
            return true;
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
    }

    /**
     * Erabiltzaileak lortu PostgreSQL-tik eta gorde SQLite-n
     */
    public void erabiltzaileakLortu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Socket-a sortu
                    Socket sk = new Socket(ip, puerto);

                    // Sarrera lortzeko objetua
                    BufferedReader entrada = new BufferedReader(new
                            InputStreamReader(sk.getInputStream()));

                    // Irteera bueltatzeko objetua
                    PrintWriter salida = new PrintWriter(
                            new OutputStreamWriter(sk.getOutputStream()), true);

                    // Abisatu zerbitzariari erabiltzaileak bidaltzeko
                    salida.println("Erabiltzaileak bidali");

                    // Borratu erabiltzaileak SQLite-tik
                    String borrau = "DELETE FROM Erabiltzaileak";
                    Login.db.execSQL(borrau);

                    String jaso = "";

                    // Erabiltzaileen string-a lortu eta objetuetan sortu eta sartu SQLite-n
                    while ((jaso = entrada.readLine()) != null) {
                        Log.d("entrada", jaso);
                        String[] erregistroak = jaso.split(";");
                        for (int i = 0; i < erregistroak.length; i++) {
                            String[] parts = erregistroak[i].split(",");
                            User user = new User(Integer.parseInt((parts[0])), (parts[1]), (parts[2]), parts[3]);
                            String insert_query = "INSERT INTO Erabiltzaileak(id,izena,email,password) VALUES (" + user.getId() + ",'" + user.getName() + "', '" + user.getEmail() + "', '" + user.getPass() + "')";
                            Login.db.execSQL(insert_query);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * SQLite-tik erabiltzaileak lortu eta konparatu login egitean
     * sartutako erabiltzailearekin
     *
     * @param u
     * @return
     */
    public boolean login(User u) {
        // Erabiltzaileak lortu eta konparatu sartutako erabiltzailearekin
        Cursor c = Login.db.rawQuery("select * from Erabiltzaileak where email='" + u.getEmail() + "' and password='" + u.getPass() + "';", null);
        while (c.moveToNext()) {
            User a = new User(c.getInt(0), c.getString(1), c.getString(2), c.getString(3));
            actualUser = a;
            return true;
        }
        return false;
    }
}