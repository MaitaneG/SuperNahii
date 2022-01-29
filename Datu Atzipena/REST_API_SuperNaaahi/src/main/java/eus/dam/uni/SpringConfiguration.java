package eus.dam.uni;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * 
 * Mongora konektatzeko konfigurazioa
 *
 */
@Configuration
public class SpringConfiguration {

	//private String connectionString="mongodb://192.168.65.2:27017";
	private String connectionString = "mongodb://localhost:27017";

	@Bean // Indicates that a method produces a bean to be managed by the Spring
			// container.
	public MongoClient mongoClient() {
		CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build()); //JavaObject <=> BSONdocument konbertsioa gauzatzeko
		CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		return MongoClients.create(MongoClientSettings.builder()
				.applyConnectionString(new ConnectionString(connectionString)).codecRegistry(codecRegistry).build());
	}

}
