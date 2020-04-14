package com.database.szte.controller;

import com.database.szte.data.Train;
import com.database.szte.service.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainController {

    @Autowired
    private ITrainService trainService;

    @GetMapping("/trains")
    public List<Train> getTrains() {
        return trainService.getAllTrains();
    }
}
