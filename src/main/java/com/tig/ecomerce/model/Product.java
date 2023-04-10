package com.tig.ecomerce.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
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
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "product")
	@JsonIgnore 
	@OrderBy("id DESC")
	private Set<Comment> comments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getEanCode() {
		return eanCode;
	}
	public void setEanCode(long eanCode) {
		this.eanCode = eanCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public Product(int id, long eanCode, String name, String description, String brand, Double price, String picture,
			int quantity, Category category, State state, Set<Comment> comments) {
		super();
		this.id = id;
		this.eanCode = eanCode;
		this.name = name;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.picture = picture;
		this.quantity = quantity;
		this.category = category;
		this.state = state;
		this.comments = comments;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", eanCode=" + eanCode + ", name=" + name + ", description=" + description
				+ ", brand=" + brand + ", price=" + price + ", picture=" + picture + ", quantity=" + quantity
				+ ", category=" + category + ", state=" + state + ", comments=" + comments + "]";
	}

	
}
