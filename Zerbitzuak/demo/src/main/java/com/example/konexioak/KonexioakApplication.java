package com.example.konexioak;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.example.konexioak.model.Puntuazioa;
import com.example.konexioak.model.User;

public class KonexioakApplication {

	public static void main(String[] args) throws IOException {

		/* Sockets */

		int port = 9000;
		ServerSocket zerbitzaria = new ServerSocket(port);

		System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.");
		Socket bezeroa = zerbitzaria.accept(); // Bezeroa

		// bezeroarekin komunikatu eta ekintzak burutu
		System.out.println("Bezeroa konektatu da!");

		InputStream is = bezeroa.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String jasotakoTestua;

		ArrayList<Puntuazioa> puntuazioak = new ArrayList<>();

		while ("agur" != (jasotakoTestua = br.readLine())) {
			System.out.println("Bezerotik jasotakoa: " + jasotakoTestua);
			if (jasotakoTestua.trim().compareTo("bukatu") == 0) {
				break; // bukletik irtengo gara
			}
			
			if (jasotakoTestua != null && !jasotakoTestua.equals("bukatu")) {
				String[] erregistroak = jasotakoTestua.split(";");

				for (int i = 0; i < erregistroak.length; i++) {
					String[] parts = erregistroak[i].split(",");
					puntuazioak.add(new Puntuazioa(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2])));
				}
			}

			postgresraBidali(puntuazioak);

			
		}

		bezeroa.close();
		zerbitzaria.close();
	}

	/**
	 * Postgresra puntuazioak bidaltzen ditu
	 * @param p
	 */
	public static void postgresraBidali(ArrayList<Puntuazioa> p) {
		KonexioaPostgre konexioaPostgre = new KonexioaPostgre();
		konexioaPostgre.connect();

		konexioaPostgre.insertPuntuazioa(p);
	}
	
	public static void mongoraBidali() {
		CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
		CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
		
		String uri = "mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
		
	}

}
