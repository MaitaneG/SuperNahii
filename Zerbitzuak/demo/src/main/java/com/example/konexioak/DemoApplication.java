package com.example.konexioak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.example.konexioak.model.Puntuazioa;
import com.example.konexioak.model.User;

public class DemoApplication {

	public static void main(String[] args) throws IOException {
		int port = 9000;
		ServerSocket zerbitzaria = new ServerSocket(port);

		System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.");
		Socket bezeroa = zerbitzaria.accept(); // 1. bezeroa

		// bezeroarekin komunikatu eta ekintzak burutu
		System.out.println("1. bezeroa konektatu da!");

		KonexioaPostgre connKonexioaPostgre = new KonexioaPostgre();
		ArrayList<User> users= connKonexioaPostgre.selectUser();
		
		connKonexioaPostgre.insertPuntuazioa(new Puntuazioa(users.get(1).getId(), users.get(1).getName(), 122));
		InputStream is = bezeroa.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String jasotakoTestua;

		while ("agur" != (jasotakoTestua = br.readLine())) {
			System.out.println("Bezerotik jasotakoa: " + jasotakoTestua);

			if (jasotakoTestua.trim().compareTo("Hola mundo") == 0) {
				break; // bukletik irtengo gara
			}
		}

		bezeroa.close();
		zerbitzaria.close();
	}

}
