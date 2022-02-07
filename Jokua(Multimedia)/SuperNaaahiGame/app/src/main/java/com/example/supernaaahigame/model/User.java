package com.example.supernaaahigame.model;

/**
 * Erabiltzaileen modeloaren klasea da
 * Klase hau enpresaren jokalariak kudeatzen du
 */
public class User {
    int id;
    String name;
    String email;
    String pass;

    /**
     * Erabiltzaileen konstruktorea
     *
     * @param id
     * @param name
     * @param email
     * @param pass
     */
    public User(int id, String name, String email, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }

    /**
     * Erabiltzaileen konstruktorea
     *
     * @param id
     * @param name
     */
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Erabiltzaileen konstruktorea
     *
     * @param id
     * @param email
     * @param pass
     */
    public User(int id, String email, String pass) {
        this.id = id;
        this.email = email;
        this.pass = pass;
    }

    /**
     * Erabiltzaileen konstruktorea
     *
     * @param email
     * @param pass
     */
    public User(String email, String pass) {
        this.email = email;
        this.pass = pass;
    }

    /**
     * @return erabiltzailearen izena
     */
    public String getName() {
        return name;
    }

    /**
     * Erabiltzailearen izena aldatzeko
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return erabiltzailearen id-a
     */
    public int getId() {
        return id;
    }

    /**
     * Erabiltzailearen id-a aldatzeko
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return erabiltzailearen emaila
     */
    public String getEmail() {
        return email;
    }

    /**
     * Erabiltzailearen emaila aldatzeko
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return erabiltzailearen pasahitza
     */
    public String getPass() {
        return pass;
    }

    /**
     * Erabiltzailearen pasahitza aldatzeko
     *
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return erabiltzailea objetuaren string-a
     */
    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    /**
     * @return beste toString metodo bat
     */
    public String toString1() {
        return id + "," + name + ',';
    }
}

