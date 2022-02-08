package eus.dam.uni.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.bson.types.ObjectId;

import lombok.Data;

/**
 * 
 * Puntuazioaren modeloa
 *
 */
@Data
public class Puntuazioa {

	private ObjectId id;
	private String jokalari;
	private int jokalariId;
	private int puntuazioa;
	private LocalDateTime data;
	
	public Puntuazioa() {
	}

	public Puntuazioa(ObjectId id, int jokalariId, String jokalari,  int puntuazioa, LocalDateTime data) {
		this.id = id;
		this.jokalari = jokalari;
		this.jokalariId=jokalariId;
		this.puntuazioa = puntuazioa;
		this.data = data;
	}


	
	

	

}
