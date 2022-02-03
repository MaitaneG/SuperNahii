package com.example.supernaaahigame.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Puntuazioa {
    private User jokalari;
    private int puntuak;
    private LocalDateTime data;

    public Puntuazioa(User jokalari, int puntuak, LocalDateTime data) {
        this.jokalari = jokalari;
        this.puntuak = puntuak;
        this.data = data;
    }

    public User getJokalari() {
        return jokalari;
    }

    public void setJokalari(User jokalari) {
        this.jokalari = jokalari;
    }

    public int getPuntuak() {
        return puntuak;
    }

    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntuazioa that = (Puntuazioa) o;
        return puntuak == that.puntuak && Objects.equals(jokalari, that.jokalari) && Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jokalari, puntuak, data);
    }

    @Override
    public String toString() {
        return  jokalari.toString1() + puntuak + ","+data+';';
    }
}
