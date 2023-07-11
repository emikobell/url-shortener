package com.emikobell.urlshortener.database; 

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document; 

@Document("urlitems")
public class URLItem {
    @Id
    private long id;

    private String longUrl;
    
    public URLItem(long id, String longUrl) {
        super();
        this.id = id;
        this.longUrl = longUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
            "URL: id = %s, longUrl = %s",
            id,
            longUrl
        );
    }
}
