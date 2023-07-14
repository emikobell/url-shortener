package com.emikobell.urlshortener;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.ResponseEntity;

import com.emikobell.urlshortener.database.URLItem;
import com.emikobell.urlshortener.database.URLRepository;

@RestController
public class UrlShortenerController {
    
    private static final String template = "http://localhost:8080/%s";
    private final AtomicLong counter = new AtomicLong();


    @PostMapping(path = "/urlshortener", consumes = "application/json", produces = "application/json")
    public ResponseEntity<UrlShortener> urlshortener(@RequestBody UrlShortenerRequest url) {
        // This should be a POST request

        // First, search db to make sure that the link doesn't already exist
        // If it does, return the shortened link already in db
        // If not, execute the following
        long id = counter.incrementAndGet();
        // If the server restarts, the db should also be purged or the id should get the next id
        String shortUrl = Encode.encodeBase62(id);
        // Change id to shortUrl for easier lookup
        createShortURL(new URLItem(shortUrl, url.longURL));

        UrlShortener urlObj = new UrlShortener(String.format(template, shortUrl), url.longURL);

        System.out.println("Successfully created urlObj");

        return ResponseEntity.ok().body(urlObj);
    }
    // Have URL decoder mapping as well
    // Mapping should be /<shortURL>
    @GetMapping("/{id}")
    public RedirectView redirectToURL(@PathVariable String id) {
        long urlKey = Encode.decodeBase62(id);
        // Using id from path variable, access db to get the equivalent URL
        // Then add the URL into the RedirectView constructor
        return new RedirectView("newURL");
    }

    // MongoDB CRUD Operations

    @Autowired
	URLRepository urlItemRepo;

    void createShortURL(URLItem urlObj) {
        System.out.println("Creating URL...");
        urlItemRepo.save(urlObj);
        System.out.println("URL Created.");
    }

    String getLongURL(String shortUrl) {
        URLItem URL = urlItemRepo.findURLByID(shortUrl);

        return URL.getLongUrl();
    }

    String getShortURL(String longURL) {
        URLItem URL = urlItemRepo.findIDByURL(longURL);

        return URL.getId();
    }

    void getURLDetails(URLItem urlObj) {
        System.out.println(
            "URL Short ID: " + urlObj.getId() +
            "\n URL Long Format: " + urlObj.getLongUrl()
        );
    }
}
