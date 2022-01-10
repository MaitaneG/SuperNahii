package com.example.supernaaahigame.konexioa;

import com.example.supernaaahigame.model.Puntuazioa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;

public class Konexioa extends Thread {
    private final String ip = "192.168.65.65";
    private final int puerto = 8080;

    public void konektatu(Puntuazioa puntuazioa){
        try{
            // Socket-a sortu
            Socket sk = new Socket(ip,puerto);
            // Sarrera lortzeko objetua
            BufferedReader entrada = new BufferedReader(new
                    InputStreamReader(sk.getInputStream()));
            // Irteera bueltatzeko objetua
            PrintWriter salida = new PrintWriter(
                    new OutputStreamWriter(sk.getOutputStream()),true);

            salida.println("Hola mundo");
        }catch(Exception ex){
            ex.printStackTrace();
            System.err.println("Konexioa gaizki egin da");
        }
    }



}
