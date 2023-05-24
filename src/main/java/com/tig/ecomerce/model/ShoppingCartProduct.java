package com.tig.ecomerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_cart_products")
public class ShoppingCartProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "shoppingCart_id")
	@JsonIgnore
	private ShoppingCart shoppingCart;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public ShoppingCartProduct(int id, ShoppingCart shoppingCart, Product product, int amount) {
		this.id = id;
		this.shoppingCart = shoppingCart;
		this.product = product;
		this.amount = amount;
	}
	public ShoppingCartProduct(ShoppingCart shoppingCart, Product product, int amount) {
		this.shoppingCart = shoppingCart;
		this.product = product;
		this.amount = amount;
	}
	public ShoppingCartProduct() {
	}
	@Override
	public String toString() {
		return "ShoppingCartProduct [id=" + id + ", shoppingCart=" + shoppingCart +  ", amount="+ amount + "]";
	}
	
}
