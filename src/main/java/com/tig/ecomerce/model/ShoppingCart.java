package com.tig.ecomerce.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_carts")
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "shoppingCart")
	List<ShoppingCartProduct> shoppingCartProducts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public List<ShoppingCartProduct> getShoppingCartProducts() {
		return shoppingCartProducts;
	}
	public void setShoppingCartProducts(List<ShoppingCartProduct> shoppingCartProducts) {
		this.shoppingCartProducts = shoppingCartProducts;
	}
	public ShoppingCart(int id, User user, State state,List<ShoppingCartProduct> shoppingCartProducts) {
		this.id = id;
		this.user = user;
		this.state = state;
		this.shoppingCartProducts = shoppingCartProducts;
	}
	public ShoppingCart(User user, State state) {
		this.user = user;
		this.state = state;
	}
	public ShoppingCart() {
	}
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", user=" + user + ", state=" + state +  "]";
	}

	
	
}
