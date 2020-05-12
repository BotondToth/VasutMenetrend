package com.database.szte.service;

import com.database.szte.data.Station;
import com.database.szte.data.Timetable;
import com.database.szte.repository.TimetableMongoRepository;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TimetableService implements ITimetableService {

    @Autowired
    private TimetableMongoRepository timetableMongoRepository;

    @Autowired
    private IStationService stationService;

    @Override
    public List<Timetable> getAllTimetables() {
        return timetableMongoRepository.findAll();
    }

    @Override
    public Timetable saveNewTimetable(final Timetable timetableToSave) {
        return timetableMongoRepository.save(timetableToSave);
    }

    @Override
    public List<Timetable> getTimetableByParams(final String start, final String end, final Instant date, final List<String> stops) {
        if ((Objects.equals(stops, null))) {
            return getTimetables(start, end, date);
        } else {
            final var stopsList = getStopStations(stops);
            if (stopsList.size() != stops.size()) {
                return new ArrayList<>();
            }
            return getTimetables(start, end, date).stream()
                    .filter(timetable -> filterStops(timetable, stopsList))
                    .collect(Collectors.toList());
        }
    }

    private boolean filterStops(final Timetable timetable, final List<Station> stops) {
        return timetable.getStops().containsAll(stops);
    }

    private List<Timetable> getTimetables(final String start, final String end, final Instant date) {
        //return timetableMongoRepository.findByStartInAndEndInAndDate(getStations(start), getStations(end), date);

        List<Station> starts = getStations(start);
        List<Station> ends = getStations(end);
        List<Timetable> list = timetableMongoRepository.findByStartInAndEndIn(starts, ends);

        List<Timetable> result = new ArrayList<>();

        for (Timetable t : list) {
            Instant time = t.getDate();

            Duration between = Duration.between(date, time);
            long secs = between.abs().getSeconds();
            if (secs <= 24*60*60){
                result.add(t);
            }
        }

        return result;
    }

    private List<Station> getStations(final String text) {
        return ListUtils.union(getByRegexCity(text), getByRegexName(text)).stream().distinct().collect(Collectors.toList());
    }

    private List<Station> getByRegexName(final String text) {
        return stationService.findByRegexName("^" + text);
    }

    private List<Station> getByRegexCity(final String text) {
        return stationService.findByRegexCity("^" + text);
    }

    private List<Station> getStopStations(final List<String> stops) {
        return stops.stream()
                .map(this::getStations)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }
}
