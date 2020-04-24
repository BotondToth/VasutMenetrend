package com.database.szte.controller;

import com.database.szte.data.City;
import com.database.szte.dto.CityDTO;
import com.database.szte.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/cities")
    public List<City> getCities() {
        return cityService.getAllCities();
    }

    @PostMapping("/city")
    public City insertNewCity(@RequestBody final CityDTO dto) {
        //TODO: ModelMapper
        return cityService.saveNewCity(new City(dto));
    }


}
