package eus.dam.uni.model;

import java.time.LocalDate;
import java.util.Objects;

import org.bson.types.ObjectId;

public class Puntuazioa {

	private ObjectId id;
	private int ida;
	private String jokalaria;
	private int puntuazioa;
	private LocalDate createDate;
	
	public Puntuazioa() {
	}

	public Puntuazioa(ObjectId id, int ida, String jokalaria, int puntuazioa, LocalDate createDate) {
		super();
		this.id = id;
		this.ida = ida;
		this.jokalaria = jokalaria;
		this.puntuazioa = puntuazioa;
		this.createDate = createDate;
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
		return Objects.hash(createDate, id, ida, jokalaria, puntuazioa);
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
		return Objects.equals(createDate, other.createDate) && Objects.equals(id, other.id) && ida == other.ida
				&& Objects.equals(jokalaria, other.jokalaria) && puntuazioa == other.puntuazioa;
	}

	@Override
	public String toString() {
		return "Puntuazioa [id=" + id + ", ida=" + ida + ", jokalaria=" + jokalaria + ", puntuazioa=" + puntuazioa
				+ ", createDate=" + createDate + "]";
	}
}
