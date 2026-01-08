package com.universalcopy.p_integrador.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idCustomer;
	@Column(nullable = false)
	private String fullName;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private Date createdAt;
	
	public Customer(String fullName, String phone, String email, String password, Date createdAt) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.createdAt = createdAt;
	}//Constructor

	public Long getIdCustomer() {
		return idCustomer;
	}//getIdCustomer
	
	public String getFullName() {
		return fullName;
	}//getFullName
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}//setFullName
	
	public String getPhone() {
		return phone;
	}//getPhone
	
	public void setPhone(String phone) {
		this.phone = phone;
	}//setPhone
	
	public String getEmail() {
		return email;
	}//setPhone
	
	public void setEmail(String email) {
		this.email = email;
	}//setEmail
	
	public String getPassword() {
		return password;
	}//getPassword
	
	public void setPassword(String password) {
		this.password = password;
	}//setPassword
	
	public Date getCreatedAt() {
		return createdAt;
	}//getCreatedAt
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}//setCreatedAt

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", fullName=" + fullName + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", createdAt=" + createdAt + "]";
	}//toString
	
	
	
	
}//Class Customer
