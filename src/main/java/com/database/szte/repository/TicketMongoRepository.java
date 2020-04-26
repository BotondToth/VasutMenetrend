package com.database.szte.repository;

import com.database.szte.data.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketMongoRepository extends MongoRepository<Ticket, String> {
}
