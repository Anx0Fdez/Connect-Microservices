package org.examen.examenad.config;

import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;
import org.examen.examenad.exceptions.ConnectionDbExcepcion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Bean
    public MongoClient mongoClient() {
        try{
            return MongoClients.create(mongoUri);
        }catch(Exception e){
            throw new ConnectionDbExcepcion("Error al conectarse a la base de mongo");
        }
    }
}
