package com.tig.ecomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long eanCode;
	private String name;
	private String description;
	private String brand;
	private Double price;
	private String picture;
	private int quantity;
	private Category category;
	private User user;
	private State state;
	
}
