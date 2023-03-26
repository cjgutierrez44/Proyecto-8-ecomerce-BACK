package com.tig.ecomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cities")
public class City {
	@Id
	private int id;
	private String name;
	private Department department;
}
