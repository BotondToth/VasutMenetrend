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
}
