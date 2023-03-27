package com.tig.ecomerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	@ManyToOne
	@JoinColumn(name = "street_type_id")
	private StreetType streetType;
	private String street;
	private String addressNumber;
	private String addressHouse;
	private String addressAditionalInfo;
	
}
