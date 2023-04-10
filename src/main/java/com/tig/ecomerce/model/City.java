package com.tig.ecomerce.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	@JsonIgnore 
	private Department department;
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
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public City(int id, String name, Department department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}
	public City() {
		
	}
	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
	
	
	
}
