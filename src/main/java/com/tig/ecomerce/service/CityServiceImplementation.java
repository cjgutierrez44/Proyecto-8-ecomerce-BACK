package com.tig.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.City;
import com.tig.ecomerce.model.Product;
import com.tig.ecomerce.repository.CityRepository;

import org.springframework.data.domain.Sort;

@Service
public class CityServiceImplementation implements CityService{
	
	@Autowired
	private CityRepository repository;
	
	@Override
	public List<City> getCities() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	@Override
	public City saveCity(City city) {
		return repository.save(city);
	}

	@Override
	public List<City> saveAllCities(List<City> cities) {
		return repository.saveAll(cities);
	}

	@Override
	public City getCityById(int id) {
		Optional<City> city = repository.findById(id);
		if(city.isPresent()) {
			return city.get();
		}
		throw new RuntimeException("City with id " + id + " is not found in database");
	}

}
