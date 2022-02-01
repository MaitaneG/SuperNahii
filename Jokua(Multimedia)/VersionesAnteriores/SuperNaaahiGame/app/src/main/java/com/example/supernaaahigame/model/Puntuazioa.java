package com.example.supernaaahigame.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Puntuazioa {
    private int id;
    private String jokalaria;
    private int puntuazioa;
    private LocalDateTime createDate;

    public Puntuazioa(int id, String jokalaria, int puntuazioa, LocalDateTime createDate) {
        this.id = id;
        this.jokalaria = jokalaria;
        this.puntuazioa = puntuazioa;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJokalaria() {
        return jokalaria;
    }

    public void setJokalaria(String jokalaria) {
        this.jokalaria = jokalaria;
    }

    public int getPuntuazioa() {
        return puntuazioa;
    }

    public void setPuntuazioa(int puntuazioa) {
        this.puntuazioa = puntuazioa;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return  id +
                "," + jokalaria +
                "," + puntuazioa +
                "," + createDate +
                ';';
    }
}
