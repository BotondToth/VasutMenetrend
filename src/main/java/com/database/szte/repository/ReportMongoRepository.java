package com.database.szte.repository;

import com.database.szte.data.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportMongoRepository extends MongoRepository<Report, String> {}
