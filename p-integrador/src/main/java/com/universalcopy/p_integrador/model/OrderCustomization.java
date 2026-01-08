package com.universalcopy.p_integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderCustomization")
public class OrderCustomization {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idOrderCustomization;
	@Column(nullable = false)
	private Double value;
	@Column(nullable = false)
	private Double extraPrice;
	
	public OrderCustomization(Double value, Double extraPrice) {
		super();
		this.value = value;
		this.extraPrice = extraPrice;
	}//Constructor

	public Long getIdOrderCustomization() {
		return idOrderCustomization;
	}//getIdOrderCustomization

	public Double getValue() {
		return value;
	}//getValue

	public void setValue(Double value) {
		this.value = value;
	}//setValue

	public Double getExtraPrice() {
		return extraPrice;
	}//getExtraPrice

	public void setExtraPrice(Double extraPrice) {
		this.extraPrice = extraPrice;
	}//setExtraPrice

	@Override
	public String toString() {
		return "OrderCustomization [idOrderCustomization=" + idOrderCustomization + ", value=" + value + ", extraPrice="
				+ extraPrice + "]";
	}//toString
	
}//Class OrderCustomization
