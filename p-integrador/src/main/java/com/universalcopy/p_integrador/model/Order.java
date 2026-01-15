package com.universalcopy.p_integrador.model;

import java.time.LocalDateTime;
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
import jakarta.persistence.PrePersist;
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
	private LocalDateTime createdAt;
	//@Column(nullable = false)
	private Double subtotal;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="idCustomer")
	private Customer customer;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderDetail> orderdetail;
	

	public Order(String status, String method, Double totalAmount, Double subtotal,
			Customer customer) {
		super();
		this.status = status;
		this.method = method;
		this.totalAmount = totalAmount;
		this.subtotal = subtotal;
		this.customer = customer;
	}//Constructor

	public Order() {
	}//Constructor vacío
	
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }//fechay hora
	
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


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}//getCreatedAt

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}//setCreatedAt
	

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Customer getCustomer() {
		return customer;
	}//getCustomer

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}//setCustomer

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", status=" + status + ", method=" + method + ", totalAmount="
				+ totalAmount + ", paymentDate=" + ", createdAt=" + createdAt + ", customer=" + customer
				+ "]";
	}//toString;
	
	
}//Class Order
