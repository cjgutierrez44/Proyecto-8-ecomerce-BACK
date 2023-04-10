package com.tig.ecomerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.State;
import com.tig.ecomerce.repository.StateRepository;

@Service
public class StateServiceImplementation implements StateService{
	
	@Autowired
	private StateRepository repository;
	
	@Override
	public List<State> getStates() {
		return repository.findAll();
	}

	@Override
	public State saveState(State state) {
		return repository.save(state);
	}

	@Override
	public State getStateById(int id) {
		Optional<State> state = repository.findById(id);
		if(state.isPresent()) {
			return state.get();
		}
		throw new RuntimeException("State doesn´t exists in database");
	}

	@Override
	public List<State> saveAllStates(List<State> states) {
		return repository.saveAll(states);
	}

}
