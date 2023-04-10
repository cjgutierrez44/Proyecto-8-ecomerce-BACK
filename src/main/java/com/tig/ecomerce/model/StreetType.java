package com.tig.ecomerce.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "street_types")
public class StreetType {
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
	public StreetType(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public StreetType(String name) {
		this.name = name;
	}
	public StreetType() {
	
	}
	@Override
	public String toString() {
		return "StreetType [id=" + id + ", name=" + name + "]";
	}
	
}
