package com.emikobell.urlshortener.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface URLRepository extends MongoRepository<URLItem, String> {

    @Query("{'id': ?0 }")
    URLItem findURLByID(long id);

    @Query("{'longUrl': ?0}")
    URLItem findIDByURL(String longUrl);
    
}
