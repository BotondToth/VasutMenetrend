package com.database.szte.service;

import com.database.szte.data.Station;

import java.util.List;

public interface IStationService {
    List<Station> getAllStations();

    Station saveNewStation(Station stationToSave);
}
