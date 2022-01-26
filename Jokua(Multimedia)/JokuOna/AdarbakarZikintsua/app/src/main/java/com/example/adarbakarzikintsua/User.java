package com.example.adarbakarzikintsua;

import java.util.Objects;

public class User {

    private int id;
    private String izena;
    private int department;
    private String dep_name;
    private String birthday;

    public User(int id, String izena, int department, String dep_name, String birthday) {
        this.id = id;
        this.izena = izena;
        this.department = department;
        this.dep_name=dep_name;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getDep_name() {
        return dep_name;
    }
    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && department == user.department && Objects.equals(izena, user.izena) && Objects.equals(dep_name, user.dep_name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, izena, department, dep_name, birthday);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", izena='" + izena + '\'' +
                ", department=" + department +
                ", dep_name='" + dep_name + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
