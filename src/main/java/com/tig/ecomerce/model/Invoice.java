package com.tig.ecomerce.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
@Table(name = "invoices")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	private long customerDocument;
	private double subTotal;
	private Double total;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "payment_method_id")
	private PaymentMethod paymentMethod;
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	@OneToMany(fetch = FetchType.LAZY,  mappedBy = "invoice")
	List<InvoiceDetail> detail;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("d M yyyy");
        
	    String dateG = dateFormat.format(new Date());
		this.date = dateG;
	}
	public long getCustomerDocument() {
		return customerDocument;
	}
	public void setCustomerDocument(long customerDocument) {
		this.customerDocument = customerDocument;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPeymentMethod(PaymentMethod peymentMethod) {
		this.paymentMethod = peymentMethod;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}	
	public List<InvoiceDetail> getDetail() {
		return detail;
	}
	public void setDetail(List<InvoiceDetail> detail) {
		this.detail = detail;
	}

	public Invoice(int id, String date, long customerDocument, double subTotal, Double total, User user, PaymentMethod paymentMethod, State state) {
		super();
		this.id = id;
		this.date = date;
		this.customerDocument = customerDocument;
		this.subTotal = subTotal;
		this.total = total;
		this.user = user;
		this.paymentMethod = paymentMethod;
		this.state = state;
	}
	public Invoice( String date, long customerDocument, double subTotal, Double total, User user, PaymentMethod paymentMethod, State state) {
		this.date = date;
		this.customerDocument = customerDocument;
		this.subTotal = subTotal;
		this.total = total;
		this.user = user;
		this.paymentMethod = paymentMethod;
		this.state = state;
	}
	public Invoice() {
	}
	
	
	
	
}
