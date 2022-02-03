package com.example.supernaaahigame.model;

import java.util.Objects;

public class Puntuazioa {
    private String izena;
    private int puntuak;

    public Puntuazioa(String izena, int puntuak) {
        this.izena = izena;
        this.puntuak = puntuak;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntuazioa that = (Puntuazioa) o;
        return puntuak == that.puntuak && Objects.equals(izena, that.izena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(izena, puntuak);
    }
}
