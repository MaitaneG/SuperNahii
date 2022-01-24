package com.example.postgresmongo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.postgresmongo.dao.RankingJuegoPuntuazioaDAO;

@SpringBootApplication
public class PostgreMongoApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(PostgreMongoApplication.class, args);

		/* Sockets */

		int port = 9000;
		ServerSocket zerbitzaria = new ServerSocket(port);

		System.out.println("Socket TCP ZERBITZARIA " + zerbitzaria.getLocalPort() + " portutik entzuten.");
		Socket bezeroa = zerbitzaria.accept(); // 1. bezeroa

		// bezeroarekin komunikatu eta ekintzak burutu
		System.out.println("Bezeroa konektatu da!");

		InputStream is = bezeroa.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String jasotakoTestua;

		while ("agur" != (jasotakoTestua = br.readLine())) {
			System.out.println("Bezerotik jasotakoa: " + jasotakoTestua);

			if (jasotakoTestua != null && !jasotakoTestua.equals("bukatu")) {
				String[] parts = jasotakoTestua.split(",");
				
				RankingJuegoPuntuazioaDAO puntuazioaDAO=new RankingJuegoPuntuazioaDAO();
				
			}

			if (jasotakoTestua.trim().compareTo("bukatu") == 0) {
				break; // bukletik irtengo gara
			}
		}

		bezeroa.close();
		zerbitzaria.close();
	}

}
