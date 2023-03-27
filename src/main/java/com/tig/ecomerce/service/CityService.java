package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.City;

public interface CityService {
	List<City> getCities();
	City saveCity(City city);
}
