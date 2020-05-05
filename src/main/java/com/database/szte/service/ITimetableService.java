package com.database.szte.service;

import com.database.szte.data.Timetable;

import java.time.Instant;
import java.util.List;

public interface ITimetableService {

    List<Timetable> getAllTimetables();

    Timetable saveNewTimetable(Timetable timetableToSave);

    List<Timetable> getTimetableByParams(String start, String end, Instant date);
}
