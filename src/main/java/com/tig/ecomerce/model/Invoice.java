package com.tig.ecomerce.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int number;
	private Date date;
	private long customerDocument;
	private double subTotal;
	private Double total;
	private User user;
	private PaymentMethod peymentMethod;
	private State state;

	//detail	
	
}
