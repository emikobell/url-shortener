package com.emikobell.urlshortener;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlShortenerController {
    
    private static final String template = "http://localhost:8080/%s";
    private final AtomicInteger counter = new AtomicInteger();

    @GetMapping("/urlshortener")
    public UrlShortener urlshortener(@RequestParam(value = "url", defaultValue = "test") String url) {
        // This should be a POST request
        // First, search db to make sure that the link doesn't already exist
        // If it does, return the shortened link already in db
        // If not, execute the following
        int id = counter.incrementAndGet();
        String shortUrl = Encode.encodeBase64(id);
        // Insert link into db
        System.out.println(shortUrl);
        return new UrlShortener(id, String.format(template, shortUrl));
    }
    // Have URL decoder mapping as well
    // Mapping should be /<shortURL>
}
