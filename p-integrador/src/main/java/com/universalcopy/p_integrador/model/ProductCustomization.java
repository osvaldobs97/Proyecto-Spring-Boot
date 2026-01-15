package com.universalcopy.p_integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "productCustomization")
public class ProductCustomization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private Double extraPrice;

	@ManyToOne
	@JoinColumn(name = "idProduct")
	private Product product;

	@ManyToOne
	@JoinColumn(name = "idCustomizationType")
	private CustomizationType customizationType;

	public ProductCustomization(Double extraPrice) {
		super();
		this.extraPrice = extraPrice;
	}// Constructor

	public ProductCustomization() {
	}// Constructor vacío

	public Long getId() {
		return id;
	}// getId

	public Double getExtraPrice() {
		return extraPrice;
	}// getExtraPrice

	public void setExtraPrice(Double extraPrice) {
		this.extraPrice = extraPrice;
	}// setExtraPrice

	public Product getProduct() {
		return product;
	}// getProduct

	public void setProduct(Product product) {
		this.product = product;
	}// setProduct

	public CustomizationType getCustomizationType() {
		return customizationType;
	}// getCustomizationType

	public void setCustomizationType(CustomizationType customizationType) {
		this.customizationType = customizationType;
	}// setCustomizationType

	@Override
	public String toString() {
	    return "ProductCustomization [id=" + id + ", extraPrice=" + extraPrice + "]";
	}


}// Class ProductCustomization
