package com.tig.ecomerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tig.ecomerce.model.Department;
import com.tig.ecomerce.service.DepartmentService;

@RestController
@RequestMapping("/departments")
@CrossOrigin(origins = "*")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("")
	public List<Department> getDepartments(){
		return departmentService.getDepartments();
	}
}
