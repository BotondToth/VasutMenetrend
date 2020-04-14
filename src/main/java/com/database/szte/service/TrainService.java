package com.database.szte.service;

import com.database.szte.data.Train;
import com.database.szte.repository.TrainMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService implements ITrainService {

    @Autowired
    private TrainMongoRepository trainMongoRepository;

    public List<Train> getAllTrains() {
        return trainMongoRepository.findAll();
    }
}
