package com.database.szte.service;

import com.database.szte.data.Train;
import com.database.szte.dto.TrainDTO;

import java.util.List;

public interface ITrainService {

    List<Train> getAllTrains();

    Train saveNewTrain(Train trainToSave);
}
