package com.example.konexioak;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.example.konexioak.model.Puntuazioa;
import com.example.konexioak.model.User;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class KonexioakApplication {

	public static void main(String[] args) throws IOException {

		/* Sockets */

		int port = 9000;
		ServerSocket zerbitzaria = new ServerSocket(port);

		System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.");
		Socket bezeroa = zerbitzaria.accept(); // Bezeroa

		// bezeroarekin komunikatu eta ekintzak burutu
		System.out.println("Bezeroa konektatu da!");

		// Sartzen den informazioa kudeatzeko
		InputStream is = bezeroa.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		// Irtetzen den informazioa kudeatzeko
		OutputStream os = bezeroa.getOutputStream();
		PrintWriter pwos = new PrintWriter(os, true);

		String jasotakoTestua;
		String bidaliBeharrekoTestua;

		ArrayList<Puntuazioa> puntuazioak = new ArrayList<>();

		// Buklea
		while ("agur" != (jasotakoTestua = br.readLine())) {

			/*
			 * if (jasotakoTestua.trim().compareTo("bukatu") == 0) { break; // bukletik
			 * irtengo gara }
			 */

			// Android-etik eskatzen da erabiltzaileak bidaltzeko
			if (jasotakoTestua.equals("Erabiltzaileak bidali")) {
				System.out.println("Bezerotik jasotakoa: " + jasotakoTestua);
				bidaliBeharrekoTestua = androideraBidaliErabiltzaileak();
				pwos.println(bidaliBeharrekoTestua);
			}

			// Puntuazioak jasotzen ditu
			if (jasotakoTestua != null && !jasotakoTestua.equals("bukatu")
					&& !jasotakoTestua.equals("Erabiltzaileak bidali")) {
				System.out.println("Bezerotik jasotakoa: " + jasotakoTestua);
				String[] erregistroak = jasotakoTestua.split(";");

				for (int i = 0; i < erregistroak.length; i++) {
					String[] parts = erregistroak[i].split(",");
					puntuazioak.add(new Puntuazioa(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2])));
				}

				postgresraBidaliPuntuazioak(puntuazioak);
				mongoraBidaliPuntuazioak(puntuazioak);
			}

		}

		bezeroa.close();

		zerbitzaria.close();
	}

	/**
	 * 
	 * @return Android-era bidaliko den informazioa
	 */
	public static String androideraBidaliErabiltzaileak() {
		KonexioaPostgre konexioaPostgre = new KonexioaPostgre();
		ArrayList<User> users = konexioaPostgre.selectUser();

		String userString = "";
		for (User user : users) {
			userString = userString + user.getId() + "," + user.getEmail() + "," + user.getPassword() + ";";
			System.out.println(userString);
		}
		return userString;
	}

	/**
	 * Postgresra puntuazioak bidaltzen ditu
	 * 
	 * @param p
	 */
	public static void postgresraBidaliPuntuazioak(ArrayList<Puntuazioa> p) {
		KonexioaPostgre konexioaPostgre = new KonexioaPostgre();
		konexioaPostgre.insertPuntuazioa(p);
	}

	/**
	 * Mongora puntuazioak bidaltzen ditu
	 * 
	 * @param puntuazioak
	 */
	public static void mongoraBidaliPuntuazioak(ArrayList<Puntuazioa> puntuazioak) {
		KonexioaMongo konexioaMongo = new KonexioaMongo();
		konexioaMongo.insertPuntuazioa(puntuazioak);
	}

}
