package com.universalcopy.p_integrador.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idOrder;
	@Column(nullable = false)
	private String status;
	@Column(nullable = false)
	private String method;
	@Column(nullable = false)
	private Double totalAmount;
	@Column(nullable = false)
	private Date paymentDate;
	@Column(nullable = false)	
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name="idCustomer")
	private Customer customer;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private List<OrderDetail> orderdetails;
	

	public Order(String status, String method, Double totalAmount, Date paymentDate, Date createdAt,
			Customer customer) {
		super();
		this.status = status;
		this.method = method;
		this.totalAmount = totalAmount;
		this.paymentDate = paymentDate;
		this.createdAt = createdAt;
		this.customer = customer;
	}//Constructor

	public Order() {
	}//Constructor vacío
	
	public Long getIdOrder() {
		return idOrder;
	}//getIdOrder

	public String getStatus() {
		return status;
	}//getStatus

	public void setStatus(String status) {
		this.status = status;
	}//setStatus

	public String getMethod() {
		return method;
	}//getMethod

	public void setMethod(String method) {
		this.method = method;
	}//setMethod

	public Double getTotalAmount() {
		return totalAmount;
	}//getTotalAmount

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}//setTotalAmount

	public Date getPaymentDate() {
		return paymentDate;
	}//getPaymentDate

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}//setPaymentDate

	public Date getCreatedAt() {
		return createdAt;
	}//getCreatedAt

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}//setCreatedAt

	public Customer getCustomer() {
		return customer;
	}//getCustomer

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}//setCustomer

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", status=" + status + ", method=" + method + ", totalAmount="
				+ totalAmount + ", paymentDate=" + paymentDate + ", createdAt=" + createdAt + ", customer=" + customer
				+ "]";
	}//toString;
	
	
}//Class Order
