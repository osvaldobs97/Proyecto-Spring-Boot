package com.universalcopy.p_integrador.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
    @Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	@Column(nullable = false)
	 private LocalDateTime createdAt;
	
	
	public Customer(String fullName, String phone, String email, String password, String role, Date createdAt) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}//Constructor

	public Customer() {
	}//Constructor
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = Role.ROLE_USER;
        }
    }
	
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
	
	public Role getRole() {
		return role;
	}//getRole

	public void setRole(Role roleAdmin) {
		this.role = roleAdmin;
	}//setRole

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}//getCreatedAt
	

	@Override
	public String toString() {
		return "Customer [idCustomer=" + idCustomer + ", fullName=" + fullName + ", phone=" + phone + ", email=" + email
				+ ", password=" + password + ", role= " + role + ", createdAt=" + createdAt + "]";
	}//toString
	
	
	
	
}//Class Customer
