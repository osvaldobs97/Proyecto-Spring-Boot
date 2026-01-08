package com.universalcopy.p_integrador.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orderDetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idOrderDetail;
	@Column(nullable = false)
	private Integer status;
	@Column(nullable = false)
	
	private Date createdAt;
	public OrderDetail(Integer status, Date createdAt) {
		super();
		this.status = status;
		this.createdAt = createdAt;
	}//Constructor
	
	public Long getIdOrderDetail() {
		return idOrderDetail;
	}//getIdOrderDetail
	
	public Integer getStatus() {
		return status;
	}//getStatus
	
	public void setStatus(Integer status) {
		this.status = status;
	}//setStatus
	
	public Date getCreatedAt() {
		return createdAt;
	}//getCreatedAt
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}//setCreatedAt

	@Override
	public String toString() {
		return "OrderDetail [idOrderDetail=" + idOrderDetail + ", status=" + status + ", createdAt=" + createdAt + "]";
	}//toString
	
	
	
	
}//Class OrderDetail
