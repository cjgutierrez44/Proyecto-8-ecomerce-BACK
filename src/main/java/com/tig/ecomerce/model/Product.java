package com.tig.ecomerce.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	//private User user;
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	
	@OneToMany(mappedBy = "product")
	private Set<Comment> comments;
	
}
