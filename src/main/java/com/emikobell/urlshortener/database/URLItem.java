package com.emikobell.urlshortener.database; 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document; 

@Document("urlitems")
public class URLItem {
    @Id
    private String shortUrl;

    private String longUrl;
    
    public URLItem(String shortUrl, String longUrl) {
        super();
        this.shortUrl = shortUrl;
        this.longUrl = longUrl;
    }

    public String getId() {
        return shortUrl;
    }

    public void setId(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getLongUrl(){
        return longUrl;
    }

    public void setLongUrl(String longUrl){
        this.longUrl = longUrl;
    }

    @Override
    public String toString() {
        return String.format(
            "URL: shortUrl = %s, longUrl = %s",
            shortUrl,
            longUrl
        );
    }
}
