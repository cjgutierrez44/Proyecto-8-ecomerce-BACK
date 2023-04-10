package com.tig.ecomerce.controller;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.City;
import com.tig.ecomerce.model.Product;
import com.tig.ecomerce.service.CityService;
import com.tig.ecomerce.service.DepartmentService;

@RestController
@RequestMapping("/cities")
@CrossOrigin(origins = "*")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("")
	public List<City> getCities() {
		return cityService.getCities();
	}
	
	@GetMapping("/byDepartmentId/{id}")
	public Set<City> getCitiesByDepartmentId(@PathVariable("id") int id) {
		return departmentService.getDepartmentById(id).getCities();
	}
	
	
}
