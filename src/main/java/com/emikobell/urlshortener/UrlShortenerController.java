package com.emikobell.urlshortener;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {
    
    private static final String template = "http://localhost:8080/%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/urlshortener")
    public UrlShortener urlshortener(@RequestParam(value = "url", defaultValue = "test") String url) {
        // This should be a POST request
        // First, search db to make sure that the link doesn't already exist
        // If it does, return the shortened link already in db
        // If not, execute the following
        long id = counter.incrementAndGet();
        String shortUrl = Encode.encodeBase62(id);
        // Insert link into db
        return new UrlShortener(id, String.format(template, shortUrl));
    }
    // Have URL decoder mapping as well
    // Mapping should be /<shortURL>
}
