package com.example.supernaaahigame;

import android.text.format.DateFormat;

import java.util.Date;

public class Puntuazioa {
    private int id,id_langilea,puntuak;
    private Date date;

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
        return date;
    }

    public void setDate(String date) {
        this.date = DateFormat("yyyy.MM.dd".toString();
    }
}
