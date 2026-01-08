package com.universalcopy.p_integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productCustomization")
public class ProductCustomization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private Double extraPrice;
	
	public ProductCustomization(Double extraPrice) {
		super();
		this.extraPrice = extraPrice;
	}//Constructor

	public Long getId() {
		return id;
	}//getId

	public Double getExtraPrice() {
		return extraPrice;
	}//getExtraPrice

	public void setExtraPrice(Double extraPrice) {
		this.extraPrice = extraPrice;
	}//setExtraPrice

	@Override
	public String toString() {
		return "ProductCustomization [id=" + id + ", extraPrice=" + extraPrice + "]";
	}//toString
	
}//Class ProductCustomization
