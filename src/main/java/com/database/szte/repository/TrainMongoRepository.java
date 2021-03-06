package com.database.szte.repository;

import com.database.szte.data.Train;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainMongoRepository extends MongoRepository<Train, String> {
}
