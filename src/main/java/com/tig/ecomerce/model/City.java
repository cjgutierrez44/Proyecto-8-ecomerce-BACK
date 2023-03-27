package com.tig.ecomerce.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
	private int id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;
	
}
