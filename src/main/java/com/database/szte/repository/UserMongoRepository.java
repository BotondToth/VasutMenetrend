package com.database.szte.repository;

import com.database.szte.data.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserMongoRepository extends MongoRepository<ApplicationUser, Long> {
    ApplicationUser findApplicationUserByEmail(String email);

    ApplicationUser findApplicationUserByUsername(String userName);
}
