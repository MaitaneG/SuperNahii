package eus.dam.uni.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import eus.dam.uni.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

/**
 * 
 * Puntuazioa datuak kontrolatzeko
 *
 */
@Repository
public class PuntuazioaDAO {
	@Autowired
	private MongoClient client;
	private MongoCollection<Puntuazioa> collection;

	/**
	 * 
	 */
	@PostConstruct
	void datuakKargatu() {
		collection = client.getDatabase("supernaaahi").getCollection("puntuazioa", Puntuazioa.class);
	}

	public List<Puntuazioa> findAll() {
		return collection.find().into(new ArrayList<>());
	}
	/*
	 * public Eskatzailea save(Eskatzailea esk){ eskatzaileak.add(esk); return esk;
	 * }
	 */
}
