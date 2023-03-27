package com.tig.ecomerce.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy = "department")
	private Set<City> cities;
}
