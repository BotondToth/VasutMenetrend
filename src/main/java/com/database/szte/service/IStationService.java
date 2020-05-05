package com.database.szte.service;

import com.database.szte.data.Station;

import java.util.List;

public interface IStationService {
    List<Station> getAllStations();

    Station saveNewStation(Station stationToSave);

    List<Station> findByRegexName(String name);

    List<Station> findByRegexCity(String city);
}
