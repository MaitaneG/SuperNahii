package eus.dam.uni.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import eus.dam.uni.model.*;

import org.bson.BsonDocument;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

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
		collection = client.getDatabase("naaahi").getCollection("puntuazioa", Puntuazioa.class);
	}

	public List<Puntuazioa> findAll() {

		return collection.find().sort(new BasicDBObject("puntuazioa", -1)).into(new ArrayList<>());
	}

	public List<Puntuazioa> puntuazio5() {
		FindIterable<Puntuazioa> puntuazioakFindIterable = collection.find().sort(new BasicDBObject("puntuazioa", -1))
				.limit(5);
		ArrayList<Puntuazioa> puntuazioas = Lists.newArrayList(puntuazioakFindIterable);
		return puntuazioas;
	}
	
	public List<Puntuazioa> puntuazio10() {
		FindIterable<Puntuazioa> puntuazioakFindIterable = collection.find().sort(new BasicDBObject("puntuazioa", -1))
				.limit(10);
		ArrayList<Puntuazioa> puntuazioas = Lists.newArrayList(puntuazioakFindIterable);
		return puntuazioas;
	}
	
	public List<Puntuazioa> puntuazio20() {
		FindIterable<Puntuazioa> puntuazioakFindIterable = collection.find().sort(new BasicDBObject("puntuazioa", -1))
				.limit(20);
		ArrayList<Puntuazioa> puntuazioas = Lists.newArrayList(puntuazioakFindIterable);
		return puntuazioas;
	}
	
	public List<Puntuazioa> findHallOfFame() {
		FindIterable<Puntuazioa> puntuazioakFindIterable = collection.find().sort(new BasicDBObject("puntuazioa", -1))
				.limit(2);
		ArrayList<Puntuazioa> puntuazioas = Lists.newArrayList(puntuazioakFindIterable);
		return puntuazioas;
	}

	public List<Puntuazioa> findHallOfShame() {
		FindIterable<Puntuazioa> puntuazioakFindIterable = collection.find().sort(new BasicDBObject("puntuazioa", +1))
				.limit(2);
		ArrayList<Puntuazioa> puntuazioas = Lists.newArrayList(puntuazioakFindIterable);
		return puntuazioas;
	}
}
