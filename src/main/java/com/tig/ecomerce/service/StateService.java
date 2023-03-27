package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.State;

public interface StateService {
	List<State> getStates();
	State saveState(State state);
}
