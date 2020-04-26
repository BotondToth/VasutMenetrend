package com.database.szte.repository;

import com.database.szte.data.Discount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountMongoRepository extends MongoRepository<Discount, String> {
}
