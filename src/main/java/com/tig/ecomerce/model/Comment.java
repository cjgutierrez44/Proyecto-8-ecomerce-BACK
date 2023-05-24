package com.tig.ecomerce.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import jakarta.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	@JsonIgnore 
	private Product product;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String comment;
	private String date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        
	    String dateG = dateFormat.format(new Date());
		this.date = dateG;

	}
	public Comment(int id, Product product, User user, String comment, String date) {
		super();
		this.id = id;
		this.product = product;
		this.user = user;
		this.comment = comment;
		DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
	        
	    String dateG = dateFormat.format(new Date());
		this.date = dateG;
	}
	public Comment(Product product, User user, String comment, String date) {
		this.product = product;
		this.user = user;
		this.comment = comment;
        DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        
        String dateG = dateFormat.format(new Date());
		this.date = dateG;
	}
	public Comment() {
		
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", product=" + product + ", user=" + user + ", comment=" + comment + ", date="
				+ date + "]";
	}


	
	
	
}
