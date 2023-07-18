package com.emikobell.urlshortener.database; 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document; 

@Document("urlitems")
public class URLItem {
    @Id
    private String shortUrl;

    private long urlNumber;
    private String longUrl;
    
    public URLItem(String shortUrl, long urlNumber, String longUrl) {
        super();
        this.shortUrl = shortUrl;
        this.urlNumber = urlNumber;
        this.longUrl = longUrl;
    }

    public String getId() {
        return shortUrl;
    }

    public void setId(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public long getURLNumber() {
        return urlNumber;
    }

    public void setURLNumber(long urlNumber) {
        this.urlNumber = urlNumber;
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
            "URL: shortUrl = %s, urlNumber = %d, longUrl = %s",
            shortUrl,
            urlNumber,
            longUrl
        );
    }
}
