package com.tig.ecomerce.model;

import jakarta.persistence.Table;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table(name = "state_types")
public class StateType {
	@Id
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StateType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public StateType() {
		super();
	}
	@Override
	public String toString() {
		return "StateType [id=" + id + ", name=" + name + "]";
	}
	
	
}
