package com.database.szte.service;

import com.database.szte.data.City;
import com.database.szte.repository.CityMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private CityMongoRepository cityMongoRepository;

    @Override
    public List<City> getAllCities() {
        return cityMongoRepository.findAll();
    }

    @Override
    public City saveNewCity(City cityToSave) {
        return cityMongoRepository.save(cityToSave);
    }
}
