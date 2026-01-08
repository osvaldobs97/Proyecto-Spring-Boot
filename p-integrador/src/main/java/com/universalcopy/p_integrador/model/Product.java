package com.universalcopy.p_integrador.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idProduct;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private String description;
	@Column(nullable = false)
	private String imageUrl;
	@Column(nullable = false)
	private Integer stock;
	@Column(nullable = false)
	private Date createdAt;
	
	public Product(String name, Double price, String description, String imageUrl, Integer stock, Date createdAt) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
		this.stock = stock;
		this.createdAt = createdAt;
	}//Constructor

	public Long getIdProduct() {
		return idProduct;
	}//getIdProduct

	public String getName() {
		return name;
	}//getName

	public void setName(String name) {
		this.name = name;
	}//setName

	public Double getPrice() {
		return price;
	}//getPrice

	public void setPrice(Double price) {
		this.price = price;
	}//setPrice

	public String getDescription() {
		return description;
	}//getDescription

	public void setDescription(String description) {
		this.description = description;
	}//setDescription

	public String getImageUrl() {
		return imageUrl;
	}//getImageUrl

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}//setImageUrl

	public Integer getStock() {
		return stock;
	}//getStock

	public void setStock(Integer stock) {
		this.stock = stock;
	}//setStock

	public Date getCreatedAt() {
		return createdAt;
	}//getCreatedAt

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}//setCreatedAt
	
	
	
	
	
}//class Product
