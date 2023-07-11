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
    public UrlShortener urlshortener(@RequestParam(value = "url") String url) {
        return new UrlShortener(0, url);
    }
}
