package com.database.szte.repository;

import com.database.szte.data.Station;
import com.database.szte.data.Timetable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TimetableMongoRepository extends MongoRepository<Timetable, String> {

    List<Timetable> findByStartInAndEndInAndDate(List<Station> start, List<Station> end, Instant date);

}
