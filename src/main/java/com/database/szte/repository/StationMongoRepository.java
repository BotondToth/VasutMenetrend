package com.database.szte.repository;

import com.database.szte.data.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationMongoRepository extends MongoRepository<Station, String> {
}
