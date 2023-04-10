package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.User;

public interface UserService {
	List<User> getUsers();
	User saveUser(User user);
	User getUserbyId(int id);
	User updateUser(User user);
	User deleteUser(int id);
	User login(String email, String password);
}
