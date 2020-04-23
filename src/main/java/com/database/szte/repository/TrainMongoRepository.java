package com.database.szte.repository;

import com.database.szte.data.Train;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrainMongoRepository extends MongoRepository<Train, String> {
}
