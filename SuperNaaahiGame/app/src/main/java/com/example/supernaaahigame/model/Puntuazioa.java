package com.example.supernaaahigame.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Puntuazioa {
    private int id, id_langilea, puntuak;
    private Date data;


    public Puntuazioa(int id_langilea, int puntuak, String data) {
        this.id_langilea = id_langilea;
        this.puntuak = puntuak;
        this.data = Date;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_langilea() {
        return id_langilea;
    }

    public void setId_langilea(int id_langilea) {
        this.id_langilea = id_langilea;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    public Date getDate() {
        return data;
    }

//    public void setData(String data) {
//        this.data = DateFormat.format("yyyy.MM.dd");
//    }
}
