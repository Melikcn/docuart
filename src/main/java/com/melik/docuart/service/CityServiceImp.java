package com.melik.docuart.service;

import com.melik.docuart.dao.CityRepository;
import com.melik.docuart.entity.City;
import com.melik.docuart.search.GenericSpecification;
import com.melik.docuart.search.SearchCriteria;
import com.melik.docuart.search.SearchOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImp implements CityService{


    private static final String CITY = "city";
    private static final String PLAKA = "plaka";


    @Override
    public List<City> findCityByNameAndPlaka(String cityName, int plaka) {
        GenericSpecification genericSpecification = new GenericSpecification<City>();
        if (!cityName.equals("_"))
            genericSpecification.add(new SearchCriteria(CITY,cityName, SearchOperation.EQUAL));
        if (plaka != -1)
            genericSpecification.add(new SearchCriteria(PLAKA,plaka, SearchOperation.EQUAL));

        return cityDao.findAll(genericSpecification);
    }

    @Autowired
    CityRepository cityDao;

    @Override
    public Optional<City> getCity(int cityId) {
        return cityDao.findById(cityId);
    }

    @Override
    public List<City> getAllCities() {
        return cityDao.findAll();
    }

    @Override
    public void addCity(City city) {
        cityDao.save(city);
    }

    @Override
    public void updateCity(City city) {
        cityDao.save(city);
    }

    @Override
    public void deleteCity(City city) {
        cityDao.delete(city);
    }

}
