package com.melik.docuart.service;

import com.melik.docuart.entity.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    Optional<City> getCity(int cityId);

    List<City> findCityByNameAndPlaka(String cityName, int plaka);

    List<City> getAllCities();

    void addCity(City city);

    void updateCity(City city);

    void deleteCity(City city);




}
