package com.database.szte.repository;

import com.database.szte.data.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityMongoRepository extends MongoRepository<City, String> {
}
