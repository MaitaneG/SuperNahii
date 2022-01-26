package com.example.adarbakarzikintsua;

import java.util.ArrayList;

public class Score {
    public String name;
    public int points;

    public Score(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "{\n\"name\": \"" + name +"\",\n" +
                "\"points\": " + points +
                "\n}";
    }
}
