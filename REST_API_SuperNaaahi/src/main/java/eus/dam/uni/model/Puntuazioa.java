package eus.dam.uni.model;

import java.time.LocalDate;
import java.util.Objects;

public class Puntuazioa {

	private int id;
	private String jokalaria;
	private int puntuazioa;
	private LocalDate createDate;
	
	public Puntuazioa() {
	}

	public Puntuazioa(int id, String jokalaria, int puntuazioa, LocalDate createDate) {
		this.id = id;
		this.jokalaria = jokalaria;
		this.puntuazioa = puntuazioa;
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createDate, id, jokalaria, puntuazioa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puntuazioa other = (Puntuazioa) obj;
		return Objects.equals(createDate, other.createDate) && id == other.id
				&& Objects.equals(jokalaria, other.jokalaria) && puntuazioa == other.puntuazioa;
	}

	@Override
	public String toString() {
		return "Puntuazioa [id=" + id + ", jokalaria=" + jokalaria + ", puntuazioa=" + puntuazioa + ", createDate="
				+ createDate + "]";
	}
}
