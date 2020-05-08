package com.database.szte.repository;

import com.database.szte.data.ApplicationUser;
import com.database.szte.data.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseMongoRepository extends MongoRepository<Purchase, String> {

    List<Purchase> findPurchaseByUser(ApplicationUser user);
}
