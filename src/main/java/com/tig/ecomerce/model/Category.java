package com.tig.ecomerce.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "category")
	@JsonIgnore 
	@OrderBy("id ASC")
	private Set<Product> products;
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

	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
	public Category(int id, String name, Set<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public Category(String name) {
		this.name = name;
	}
	
	public Category() {
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
	
}
