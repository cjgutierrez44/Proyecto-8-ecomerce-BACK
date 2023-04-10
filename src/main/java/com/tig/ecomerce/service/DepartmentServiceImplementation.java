package com.tig.ecomerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.Department;
import com.tig.ecomerce.repository.DepartmentRepository;

@Service
public class DepartmentServiceImplementation implements DepartmentService{
	
	@Autowired
	private DepartmentRepository repository;
	
	@Override
	public List<Department> getDepartments() {
		return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}

	@Override
	public Department saveDepartment(Department department) {
		return repository.save(department);
	}

	@Override
	public List<Department> saveAllDepartments(List<Department> departments) {
		return repository.saveAll(departments);
	}

	@Override
	public Department getDepartmentById(int id) {
		return repository.getById(id);
	}



}
