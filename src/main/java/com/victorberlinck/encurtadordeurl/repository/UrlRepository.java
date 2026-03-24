package com.victorberlinck.encurtadordeurl.repository;

import com.victorberlinck.encurtadordeurl.entity.Url;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {

}
