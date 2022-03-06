package com.melik.docuart.rest;

import com.melik.docuart.entity.City;
import com.melik.docuart.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/city")
public class CityController {

    @Autowired
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;

    }

    @GetMapping("{cityId}")
    public Optional<City> getCity(@PathVariable int cityId){
        Optional<City> city = cityService.getCity(cityId);

        if (city == null){
            throw new RuntimeException("No Such cityId " + cityId);
        }

        return city;
    }

    @GetMapping("all")
    public List<City> getAllCities(){
        return cityService.getAllCities();
    }

    @PostMapping
    public City addCity(@RequestBody City city){
        cityService.addCity(city);

        return city;
    }

    @PutMapping
    public City updateCity(@RequestBody City city) {
        cityService.updateCity(city);

        return city;
    }

    @DeleteMapping("{cityId}")
    public String deleteCity(@PathVariable int cityId){
        Optional<City> city = cityService.getCity(cityId);

        if (city == null){
            throw new RuntimeException("No Such cityId" + cityId);
        }
        cityService.deleteCity(city.get());
        return "deleted city with id " + cityId;
    }

    @GetMapping("/query")
    public List<City> query(@RequestParam String city, @RequestParam String plaka){

        String c = city;
        int p;

        if (city.length() == 0)
            c = "_";

        if (plaka.length() == 0) {
            p = -1;
        }
        else
            p = Integer.parseInt(plaka);

        return cityService.findCityByNameAndPlaka(c,p);
    }
}
