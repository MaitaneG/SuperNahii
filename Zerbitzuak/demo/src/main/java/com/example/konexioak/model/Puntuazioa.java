package com.example.konexioak.model;

import java.time.LocalDate;

public class Puntuazioa {
	private int jokalariId;
	private String jokalari;
	private int puntuazioa;
	private LocalDate data;
	private int create_uid;
	private LocalDate date;
	private int write_uid;
	private LocalDate write_date;
	
	public Puntuazioa(int jokalariId, String jokalari, int puntuazioa) {
		this.jokalariId = jokalariId;
		this.jokalari = jokalari;
		this.puntuazioa = puntuazioa;
	}

	public int getJokalariId() {
		return jokalariId;
	}

	public void setJokalariId(int jokalariId) {
		this.jokalariId = jokalariId;
	}

	public String getJokalari() {
		return jokalari;
	}

	public void setJokalari(String jokalari) {
		this.jokalari = jokalari;
	}

	public int getPuntuazioa() {
		return puntuazioa;
	}

	public void setPuntuazioa(int puntuazioa) {
		this.puntuazioa = puntuazioa;
	}
	
	
}
