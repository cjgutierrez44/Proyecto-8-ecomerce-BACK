package com.tig.ecomerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.User;
import com.tig.ecomerce.service.CityService;
import com.tig.ecomerce.service.StateService;
import com.tig.ecomerce.service.StreetTypeService;
import com.tig.ecomerce.service.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CityService cityService;
	@Autowired
	private StreetTypeService streetTypeService;
	@Autowired
	private StateService stateService;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		user.setCity(cityService.getCityById(user.getCity().getId()));
		user.setStreetType(streetTypeService.getStreetTypeById(user.getStreetType().getId()));
		user.setState(stateService.getStateById(3));
		System.out.println(user.toString());
		return userService.saveUser(user);	
	}
	
	@PostMapping("/login")
	public User login(@RequestParam String email, @RequestParam String password) {
		User u = userService.login(email, password);
		return u;
	}
	
}
