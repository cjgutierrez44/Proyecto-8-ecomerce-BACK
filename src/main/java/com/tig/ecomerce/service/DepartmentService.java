package com.tig.ecomerce.service;

import java.util.List;

import com.tig.ecomerce.model.Department;

public interface DepartmentService {
	List<Department> getDepartments();
	Department saveDepartment(Department department);
}
