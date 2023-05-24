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
@Table(name = "invoice_product_detail")
public class InvoiceDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	@JsonIgnore
	private Invoice invoice;
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	private double price;
	private int amount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Invoice getInvoice() {
		return invoice;
	}
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public InvoiceDetail(int id, Invoice invoice, Product product, double price, int amount) {
		this.id = id;
		this.invoice = invoice;
		this.product = product;
		this.price = price;
		this.amount = amount;
	}
	public InvoiceDetail(Invoice invoice, Product product, double price, int amount) {
		this.invoice = invoice;
		this.product = product;
		this.price = price;
		this.amount = amount;
	}
	public InvoiceDetail() {
	}
	
	
}
