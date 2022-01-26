package com.example.adarbakarzikintsua;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Connect {

    public static Connection connection=null;
    public static List<User> users=new ArrayList<>();
    public static User jokalaria;
    private SQLiteDatabase db;

    /*
   Datu basera konektatzeko datuak
*/
    private final String user = "admin";
    private final String pass = "Pa$$w0rd";
    private String url = "jdbc:postgresql://192.168.65.210:5432/AdarbakarZikintsua";
    public static boolean status;
    public static int highScore=0;


    public Connect( SQLiteDatabase db) {
        this.db=db;
        connect();
    }

    /*
        Datu basera konektatzen da thread bat sortuz
     */
    public void connect() {
        Thread thread = new Thread(() -> {
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, pass);
                status = true;
                getHighScore();
                getUsers();

            } catch (Exception e) {
                status = false;
                localDbScore();
            }
            Log.d("odoo", "" + status);

        });
        thread.start();
    }

    public void localDbScore(){
        Thread thread = new Thread(() -> {
            try {
                Cursor cursor = db.rawQuery("SELECT MAX(puntuazioa) FROM scores", null);
                if (cursor.moveToNext()) {
                    highScore=cursor.getInt(0);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            Log.d("odoo", "" + highScore);
        });
        thread.start();
    }

    public static void igoPuntuazioak(List<Puntuazioa> puntuazioak) {
        Thread thread = new Thread(() -> {
            try {
                Statement st = connection.createStatement();

                String sql = "INSERT INTO adarbakarzikintsua_puntuazioa (name, puntuazioa, create_uid, create_date, write_uid,write_date,id_user) VALUES";
                int i = 1;
                for (Puntuazioa p : puntuazioak) {
                    sql += "('" + p.getIzena()+ "'," + p.getPuntuak() +  ", 1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP,"+jokalaria.getId()+")";

                    if (puntuazioak.size() > i) {
                        sql += ",";
                    } else {
                        sql += ";";
                    }
                    if(highScore<p.getPuntuak()){
                        highScore=p.getPuntuak();
                    }
                    i++;
                }

                st.execute(sql);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            Log.d("odoo", "" + highScore);
        });
        thread.start();

    }
    public void getHighScore(){
        Thread thread = new Thread(() -> {
            try {
                Statement st = connection.createStatement();

                String sql = "SELECT MAX(puntuazioa) FROM adarbakarzikintsua_puntuazioa;";

                ResultSet rd=st.executeQuery(sql);

                while(rd.next()){
                    highScore=st.getResultSet().getInt(1);
                }

            } catch (SQLException throwables) {
                //throwables.printStackTrace();
            }
            Log.d("odoo", "" + highScore);
        });
        thread.start();
    }

    public void getUsers(){

        Thread thread = new Thread(() -> {
            try {
                Statement st = connection.createStatement();

                String sql = "SELECT res_users.id,login,birthday,department_id, hr_department.name " +
                        "FROM res_users inner join hr_employee on res_users.id =hr_employee.user_id " +
                        "inner join hr_department on hr_department.id = hr_employee.department_id " +
                        "WHERE res_users.active=true ORDER BY id;";

                ResultSet rd=st.executeQuery(sql);

                while(rd.next()){
                    users.add(new User(rd.getInt(1),rd.getString(2),rd.getInt(4),rd.getString(5),rd.getString(3)));
                    Log.d("odoo","ID: " + rd.getInt(1)+ " NAME: " +rd.getString(2)+ " birthday: " + rd.getString(3)+ " department: " +rd.getInt(4));
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
                Log.d("odoo", "DATA NOT FOUND");
            }

        });
        thread.start();

    }

    public boolean isStatus() {
        return status;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }

}
