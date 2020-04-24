package com.database.szte.controller;

import com.database.szte.data.Station;
import com.database.szte.dto.StationDTO;
import com.database.szte.service.IStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationController {

    @Autowired
    private IStationService stationService;

    @GetMapping("/stations")
    public List<Station> getStations() {
        return stationService.getAllStations();
    }

    @PostMapping("/station")
    public Station insertNewStation(@RequestBody final StationDTO dto) {
        //TODO: ModelMapper
        return stationService.saveNewStation(new Station(dto));
    }

}
