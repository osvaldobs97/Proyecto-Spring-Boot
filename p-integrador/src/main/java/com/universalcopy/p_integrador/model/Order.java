package com.universalcopy.p_integrador.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private Double amount;
	@Column(nullable = false)
	private Date paymentDate;
	@Column(nullable = false)
	
	private Date createdAt;
	public Order(String status, Date createdAt, Double amount, Date paymentDate) {
		super();
		this.status = status;
		this.createdAt = createdAt;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}//Constructor
	
	public Long getIdOrder() {
		return idOrder;
	}//getIdOrder
	
	public String getStatus() {
		return status;
	}//getStatus
	
	public void setStatus(String status) {
		this.status = status;
	}//setStatus
	
	public Date getCreatedAt() {
		return createdAt;
	}//getCreatedAt
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}//setCreatedAt

	public String getMethod() {
		return method;
	}//getMethod

	public void setMethod(String method) {
		this.method = method;
	}//setMethod

	public Date getPaymentDate() {
		return paymentDate;
	}//getPaymentDate

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}//setPaymentDate

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", status=" + status + ", method=" + method + ", amount=" + amount
				+ ", paymentDate=" + paymentDate + ", createdAt=" + createdAt + "]";
	}//toString
	
}//Class Order
