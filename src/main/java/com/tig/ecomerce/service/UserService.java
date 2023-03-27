package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.User;

public interface UserService {
	List<User> getUsers();
	User saveUser();
	User getUserbyId();
	User updateUser();
	User deleteUser();
	User resetPassword();
}
