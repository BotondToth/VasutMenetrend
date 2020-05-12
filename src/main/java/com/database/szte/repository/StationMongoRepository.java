package com.database.szte.repository;

import com.database.szte.data.Station;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationMongoRepository extends MongoRepository<Station, String> {

    @Query("{ 'city' : { $regex: ?0, '$options' : 'i' } }")
    List<Station> findByRegexCity(String city);

    @Query("{ 'name' : { $regex: ?0, '$options' : 'i' } }")
    List<Station> findByRegexName(String name);
}
