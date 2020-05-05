package com.database.szte.service;

import com.database.szte.data.Station;
import com.database.szte.repository.StationMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService implements IStationService {

    @Autowired
    private StationMongoRepository stationMongoRepository;

    @Override
    public List<Station> getAllStations() {
        return stationMongoRepository.findAll();
    }

    @Override
    public Station saveNewStation(final Station stationToSave) {
        return stationMongoRepository.save(stationToSave);
    }

    @Override
    public List<Station> findByRegexName(final String name) {
        return stationMongoRepository.findByRegexName(name);
    }

    @Override
    public List<Station> findByRegexCity(final String city) {
        return stationMongoRepository.findByRegexCity(city);
    }
}
