package com.tig.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.State;
import com.tig.ecomerce.model.StateType;
import com.tig.ecomerce.repository.StateTypeRepository;

@Service
public class StateTypeServiceImplementation implements StateTypeService{
	
	@Autowired
	private StateTypeRepository repository;
	
	@Override
	public List<StateType> getStatetypes() {
		return repository.findAll();
	}

	@Override
	public StateType saveStateType(StateType stateType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StateType> saveAllStatetypes(List<StateType> stateTypes) {
		return repository.saveAll(stateTypes);
	}

	@Override
	public StateType getStateTypeById(int id) {
		Optional<StateType> stateType = repository.findById(id);
		if(stateType.isPresent()) {
			return stateType.get();
		}
		throw new RuntimeException("State Type doesn´t exists in database");
	}

}
