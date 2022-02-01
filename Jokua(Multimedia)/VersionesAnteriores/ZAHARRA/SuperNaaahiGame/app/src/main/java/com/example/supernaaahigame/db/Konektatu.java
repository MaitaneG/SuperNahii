package com.example.supernaaahigame.db;

import com.example.supernaaahigame.model.Puntuazioa;
import com.example.supernaaahigame.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class Konektatu {
    private Connection connection;

    public static ArrayList<User> users = new ArrayList<>();
    public static ArrayList<Puntuazioa> puntuazioak = new ArrayList<>();
    private int id;
    private Semaphore s1 = new Semaphore(1);
    private boolean status;
    private boolean logeatu = false;

    //    Konexiorako datuak
    private final String host = "192.168.65.11";
    private final String database = "Admin";
    private final int port = 5432;
    private final String user = "openpg";
    private final String pass = "openpgpwd";
    private String url = "jdbc:postgresql://%s:%d/%s";

    public Konektatu() {
        this.url = String.format(this.url, this.host, this.port, this.database);
        connect();
    }

    public void connect() {
        Thread thread = new Thread(new Runnable() {
            //            Datu basera konektatu
            @Override
            public void run() {
                try {
                    Class.forName("org.postgresql.Driver");
                    connection = DriverManager.getConnection(url, user, pass);
                    status = true;
                    System.out.println("connected:" + status);
                } catch (Exception e) {
                    status = false;
                    System.out.print(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            this.status = false;
        }
    }


    public boolean login(String user, String pass) {
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Statement sentencia = connection.createStatement();
//                      Saltzailearentzat login-a
                    ResultSet rs = sentencia.executeQuery("SELECT login, pass FROM login WHERE login= '" + user + "'AND pass= '" + pass + "'");
                    while (rs.next()) {
                        User u = new User(rs.getString("login"), rs.getString("pass"));
                        users.add(u);
                        logeatu = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread3.start();
        try {
            thread3.join();
            Thread.interrupted();
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
        return logeatu;
    }
    public void insert(int id_langile, int puntuak,String data) {
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Statement sentencia = connection.createStatement();

                    ResultSet rs = sentencia.executeQuery("INSERT INTO puntuazioak (id_langilea, puntuak, data) VALUES " + id_langile  + "," +puntuak+","+data );
                    while(rs.next()){
                        Puntuazioa p= new Puntuazioa(rs.getInt("id_langilea"),rs.getInt("puntuazioa"),rs.getDate("data"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        thread4.start();
        try {
            thread4.join();
            Thread.interrupted();
        } catch (Exception e) {
            e.printStackTrace();
            status = false;
        }
    }
}










