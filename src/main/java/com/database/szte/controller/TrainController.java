package com.database.szte.controller;

import com.database.szte.data.Train;
import com.database.szte.dto.TrainDTO;
import com.database.szte.service.ITrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainController {
    //swagger: localhost:8080/swagger-ui.html
    @Autowired
    private ITrainService trainService;

    @GetMapping("/trains")
    public List<Train> getTrains() {
        return trainService.getAllTrains();
    }

    @PostMapping("/train")
    public Train insertNewTraing(@RequestBody final TrainDTO dto) {
        //TODO: ModelMapper
        return trainService.saveNewTrain(new Train(dto));
    }
}
