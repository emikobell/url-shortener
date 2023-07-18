package com.emikobell.urlshortener;

import java.util.concurrent.atomic.AtomicLong;

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

        String shortUrl;

        if (longURLExists(url.longURL)) {
            shortUrl = getShortURL(url.longURL);
        } else {
            long id = counter.incrementAndGet();
            shortUrl = Encode.encodeBase62(id);
            // If the server restarts, the id should get the next highest id
            if (shortURLExists(shortUrl)) {
                id = getLongestID()+1;
                shortUrl = Encode.encodeBase62(id);
            }
            createShortURL(new URLItem(shortUrl, id, url.longURL));
        }
        
        UrlShortener urlObj = new UrlShortener(String.format(template, shortUrl), url.longURL);

        return ResponseEntity.ok().body(urlObj);
    }


    @GetMapping("/{id}")
    public RedirectView redirectToURL(@PathVariable String id) {
        String longURL = getLongURL(id);

        return new RedirectView(longURL);
    }

    // MongoDB CRUD Operations

    @Autowired
	URLRepository urlItemRepo;

    void createShortURL(URLItem urlObj) {
        urlItemRepo.save(urlObj);
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

    boolean shortURLExists(String shortUrl) {
        return urlItemRepo.existsById(shortUrl);
    }

    boolean longURLExists(String longUrl) {
        return urlItemRepo.existsByLongURL(longUrl);
    }

    long getLongestID() {
        return urlItemRepo.findTop1ByOrderByUrlNumberDesc().getURLNumber();
    }
}
