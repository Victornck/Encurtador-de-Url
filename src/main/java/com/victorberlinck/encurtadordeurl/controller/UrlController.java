package com.victorberlinck.encurtadordeurl.controller;

import com.victorberlinck.encurtadordeurl.dto.UrlRequestdto;
import com.victorberlinck.encurtadordeurl.dto.UrlShortenResponsedto;
import com.victorberlinck.encurtadordeurl.entity.Url;
import com.victorberlinck.encurtadordeurl.repository.UrlRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
public class UrlController {

    private final UrlRepository urlRepository;

    public UrlController(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @PostMapping(value ="/shorten-url")
    public ResponseEntity<UrlShortenResponsedto> shortenUrl(@RequestBody UrlRequestdto request, HttpServletRequest servletRequest){

        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5,10);
        }
        while (urlRepository.findById(id).isPresent());
        urlRepository.save(new Url(id, request.url(), LocalDateTime.now().plusMinutes(1)));

        String redirectUrl = servletRequest.getRequestURL().toString().replace("shorten-url",id);

        return ResponseEntity.ok(new UrlShortenResponsedto(redirectUrl));
    }

    @GetMapping("{id}")
    public ResponseEntity<Void> redirect(@PathVariable("id") String id){

       Optional<Url> url = urlRepository.findById(id);

       if (url.isEmpty()){
           return ResponseEntity.notFound().build();
       }

       HttpHeaders headers = new HttpHeaders();
       headers.setLocation(URI.create(url.get().getUrl()));

       return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

}
