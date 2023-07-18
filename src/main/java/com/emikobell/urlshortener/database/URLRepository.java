package com.emikobell.urlshortener.database;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface URLRepository extends MongoRepository<URLItem, String> {

    @Query("{'shortUrl': ?0 }")
    URLItem findURLByID(String shortUrl);

    @Query("{'longUrl': ?0}")
    URLItem findIDByURL(String longUrl);

    @Query(value = "{'longUrl': ?0}", exists = true)
    boolean existsByLongURL(String longUrl);

    URLItem findTop1ByOrderByUrlNumberDesc();
}
