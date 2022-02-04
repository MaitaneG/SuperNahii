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
	 * Datuak kargatzen dira MongoDB-tik
	 */
	@PostConstruct
	public void datuakKargatu() {
		collection = client.getDatabase("naaahi").getCollection("puntuazioa", Puntuazioa.class);
	}

	/**
	 * 
	 * @return Puntuazio guztiak
	 */
	public List<Puntuazioa> findAll() {

		return collection.find().sort(new BasicDBObject("puntuazioa", -1)).into(new ArrayList<>());
	}

	/**
	 * 
	 * @return Bost onenak
	 */
	public List<Puntuazioa> findHallOfFame() {
		FindIterable<Puntuazioa> puntuazioakFindIterable = collection.find().sort(new BasicDBObject("puntuazioa", -1))
				.limit(5);
		ArrayList<Puntuazioa> puntuazioas = Lists.newArrayList(puntuazioakFindIterable);
		return puntuazioas;
	}

	/**
	 * 
	 * @return Bost txarrenak
	 */
	public List<Puntuazioa> findHallOfShame() {
		FindIterable<Puntuazioa> puntuazioakFindIterable = collection.find().sort(new BasicDBObject("puntuazioa", +1))
				.limit(5);
		ArrayList<Puntuazioa> puntuazioas = Lists.newArrayList(puntuazioakFindIterable);
		return puntuazioas;
	}

	/**
	 * 
	 * @return Partehartutako langile kopurua
	 */
	public int countPartehartzaileak() {
		return Math.toIntExact(collection.countDocuments());
	}
}
