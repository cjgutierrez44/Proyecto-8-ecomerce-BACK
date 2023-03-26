package com.tig.ecomerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	private int phone;
	private String password;
	private City city;
	private StreetType streetType;
	private String street;
	private String addressNumber;
	private String addressHouse;
	private String addressAditionalInfo;
	
}
