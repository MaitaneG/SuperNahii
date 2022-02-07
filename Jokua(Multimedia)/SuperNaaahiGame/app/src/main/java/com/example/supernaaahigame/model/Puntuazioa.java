package com.example.supernaaahigame.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Puntuazioeen modeloaren klasea da
 * Klase hau jolasaren puntuazioak kudeatzen du
 */
public class Puntuazioa {
    private User jokalari;
    private int puntuak;
    private LocalDateTime data;

    /**
     * Puntuazioen kontruktorea
     *
     * @param jokalari
     * @param puntuak
     * @param data
     */
    public Puntuazioa(User jokalari, int puntuak, String data) {
        this.jokalari = jokalari;
        this.puntuak = puntuak;
        this.data = LocalDateTime.parse(data);
    }

    /**
     * @return jokalariaren objektua
     */
    public User getJokalari() {
        return jokalari;
    }

    /**
     * Jokalariaren objektua aldatzeko
     *
     * @param jokalari
     */
    public void setJokalari(User jokalari) {
        this.jokalari = jokalari;
    }

    /**
     * @return partidaren puntuazioa
     */
    public int getPuntuak() {
        return puntuak;
    }

    /**
     * Partidaren puntuazioak aldatzeko
     *
     * @param puntuak
     */
    public void setPuntuak(int puntuak) {
        this.puntuak = puntuak;
    }

    /**
     * @return partidaren data
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * Partidaren data aldatzeko
     *
     * @param data
     */
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    /**
     * Bi Puntuazio objektu konparatzeko
     *
     * @param o
     * @return Berdina den edo ez
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puntuazioa that = (Puntuazioa) o;
        return puntuak == that.puntuak && Objects.equals(jokalari, that.jokalari) && Objects.equals(data, that.data);
    }

    /**
     * @return jokalariaren hashcode bueltzeko
     */
    @Override
    public int hashCode() {
        return Objects.hash(jokalari, puntuak, data);
    }

    /**
     * @return Puntuazio objektuaren string-a bueltazeko
     */
    @Override
    public String toString() {
        return jokalari.toString1() + puntuak + "," + data + ';';
    }
}
