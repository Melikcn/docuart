package com.melik.docuart.dao;

import com.melik.docuart.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City, Integer> , JpaSpecificationExecutor<City> {

}
