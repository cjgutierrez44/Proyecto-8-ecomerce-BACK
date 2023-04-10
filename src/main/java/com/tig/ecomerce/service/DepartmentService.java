package com.tig.ecomerce.service;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.tig.ecomerce.model.Department;

public interface DepartmentService {
	List<Department> getDepartments();
	Department saveDepartment(Department department);
	List <Department> saveAllDepartments(List <Department> departments);
	Department getDepartmentById(int  id);
	

}
