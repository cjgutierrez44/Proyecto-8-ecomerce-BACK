package com.tig.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.City;
import com.tig.ecomerce.model.StreetType;
import com.tig.ecomerce.repository.StreetTypeRepository;
@Service
public class StreetTypeServiceImplementation implements StreetTypeService{

	@Autowired
	private StreetTypeRepository repository;
	
	@Override
	public List<StreetType> getStreetTypes() {
		return repository.findAll();
	}

	@Override
	public StreetType saveStreetType(StreetType streetType) {
		return repository.save(streetType);
	}

	@Override
	public List<StreetType> saveAllStreetTypes(List<StreetType> streetTypes) {
		repository.deleteAll();
		return repository.saveAll(streetTypes);
	}

	@Override
	public StreetType getStreetTypeById(int id) {
		Optional<StreetType> streetType = repository.findById(id);
		if(streetType.isPresent()) {
			return streetType.get();
		}
		throw new RuntimeException("StreetType with id " + id + " is not found in database");
	}

}
