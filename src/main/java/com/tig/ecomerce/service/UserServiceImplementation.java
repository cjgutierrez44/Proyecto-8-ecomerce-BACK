package com.tig.ecomerce.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.User;
import com.tig.ecomerce.repository.StateRepository;
import com.tig.ecomerce.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	
	
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private StateService stateService; 
	
	@Override
	public List<User> getUsers() {
		return repository.findAll();
	}

	@Override
	public User saveUser(User user) {
		return repository.save(user);
	}

	@Override
	public User getUserbyId(int id) {
		Optional<User> user = repository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		throw new RuntimeException("User is not found in database");
	}

	@Override
	public User updateUser(User user) {
		Optional<User> u = repository.findById(user.getId());
		if(u.isPresent()) {
			repository.save(user);
		}
		throw new RuntimeException("User doesn't exist in database");
	}

	@Override
	public User deleteUser(int id) {
		Optional<User> u = repository.findById(id);
		if(u.isPresent()) {
			u.get().setState(stateService.getStateById(2));
		}
		throw new RuntimeException("User doesn't exist in database");
	}

	@Override
	public User login(String email, String password) {
		Optional<User> u = repository.findByEmail(email);
		if(u.isPresent() && u.get().getPassword().equals(password)) {
			u.get().setPassword("");
			return u.get();
		}
		return null;
	}

}
