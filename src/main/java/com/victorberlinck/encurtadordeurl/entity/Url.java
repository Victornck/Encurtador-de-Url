package com.victorberlinck.encurtadordeurl.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "urls")
public class Url {

    @Id
    private String id;

    private String url;

    private String shortenUrl;;

    @Indexed(expireAfter = "0s")
    private LocalDateTime expiryDate;

    public Url() {
    }

    public Url(String id, String url, String shortenUrl, LocalDateTime expiryDate) {
        this.id = id;
        this.url = url;
        this.expiryDate = expiryDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getShortenUrl() {
        return shortenUrl;
    }

    public String getUrl() {
        return url;
    }
    public Url(String id, String url, LocalDateTime expiryDate) {
        this.id = id;
        this.url = url;
        this.expiryDate = expiryDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
