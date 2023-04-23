package com.tig.ecomerce.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String lastName;
	private int phone;
	private String email;
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
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "user")
	@JsonIgnore 
	@OrderBy("id ASC")
	private Set<Product> products;
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public StreetType getStreetType() {
		return streetType;
	}
	public void setStreetType(StreetType streetType) {
		this.streetType = streetType;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddressNumber() {
		return addressNumber;
	}
	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}
	public String getAddressHouse() {
		return addressHouse;
	}
	public void setAddressHouse(String addressHouse) {
		this.addressHouse = addressHouse;
	}
	public String getAddressAditionalInfo() {
		return addressAditionalInfo;
	}
	public void setAddressAditionalInfo(String addressAditionalInfo) {
		this.addressAditionalInfo = addressAditionalInfo;
	}
	
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	

	public User(int id, String name, String lastName, int phone, String email, String password, City city,
			StreetType streetType, String street, String addressNumber, String addressHouse,
			String addressAditionalInfo, Set<Product> products, State state) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.city = city;
		this.streetType = streetType;
		this.street = street;
		this.addressNumber = addressNumber;
		this.addressHouse = addressHouse;
		this.addressAditionalInfo = addressAditionalInfo;
		this.products = products;
		this.state = state;
	}
	public User(String name, String lastName, int phone, String email, String password, City city,
			StreetType streetType, String street, String addressNumber, String addressHouse,
			String addressAditionalInfo, State state) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.city = city;
		this.streetType = streetType;
		this.street = street;
		this.addressNumber = addressNumber;
		this.addressHouse = addressHouse;
		this.addressAditionalInfo = addressAditionalInfo;
		this.state = state;
	}
	public User(int id) {
		this.id = id;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", city=" + city + ", streetType=" + streetType + ", street=" + street
				+ ", addressNumber=" + addressNumber + ", addressHouse=" + addressHouse + ", addressAditionalInfo="
				+ addressAditionalInfo + ", state=" + state + "]";
	}


		
	
}
