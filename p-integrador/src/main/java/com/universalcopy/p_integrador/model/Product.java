package com.universalcopy.p_integrador.model;

import java.time.LocalDateTime;
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
import jakarta.persistence.PrePersist;
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
	
	private Integer stock;
	@Column(nullable = false)
    private LocalDateTime createdAt;

	
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductCustomization> customizations;
	
	
	public Product(String name, Double price, String description, String imageUrl, Integer stock, Date createdAt) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.imageUrl = imageUrl;
		this.stock = stock;
		
	}//Constructor
	
	@PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }//fechay hora
	
	
	public Product() {
	}//Constructor vacío

	
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


	public LocalDateTime getCreatedAt() {
		return createdAt;
	}//getCreatedAt


	public Category getCategory() {
		return category;
	}//getCategory

	public void setCategory(Category category) {
		this.category = category;
	}//setCategory
	
	
}//class Product
