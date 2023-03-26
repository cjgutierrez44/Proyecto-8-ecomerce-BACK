package com.tig.ecomerce.model;

import jakarta.persistence.Table;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "table")
public class StateType {
	@Id
	private int id;
	private String name;
}
