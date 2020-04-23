package com.database.szte.service;

import com.database.szte.data.City;

import java.util.List;

public interface ICityService {
    List<City> getAllCities();

    City saveNewCity(City cityToSave);
}
