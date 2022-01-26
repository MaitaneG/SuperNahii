package com.example.postgremongokonexioak.model;

import java.time.LocalDateTime;

public class Puntuazioa {
	private int jokalariaId;
	private String jokalaria;
	private int puntuazioa;
	private LocalDateTime data;
	
	public Puntuazioa(int jokalariaId, String jokalaria, int puntuazioa, String data) {
		this.jokalariaId = jokalariaId;
		this.jokalaria = jokalaria;
		this.puntuazioa = puntuazioa;
		this.data=LocalDateTime.parse(data);
	}

	public int getJokalariaId() {
		return jokalariaId;
	}

	public void setJokalariaId(int jokalariaId) {
		this.jokalariaId = jokalariaId;
	}

	public String getJokalaria() {
		return jokalaria;
	}

	public void setJokalaria(String jokalaria) {
		this.jokalaria = jokalaria;
	}

	public int getPuntuazioa() {
		return puntuazioa;
	}

	public void setPuntuazioa(int puntuazioa) {
		this.puntuazioa = puntuazioa;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
