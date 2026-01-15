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
	
	@ManyToOne
	@JoinColumn(name="idCustomizationType")
	private CustomizationType customizationType;
	
	@ManyToOne
	@JoinColumn(name="idOrderDetail")
	private OrderDetail orderDetail;
	
	public OrderCustomization(Double value, Double extraPrice) {
		super();
		this.value = value;
		this.extraPrice = extraPrice;
	}//Constructor

	public OrderCustomization() {
	}//Constructor vacío
	
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

	public CustomizationType getCustomizationType() {
		return customizationType;
	}

	public void setCustomizationType(CustomizationType customizationType) {
		this.customizationType = customizationType;
	}//setCustomizationType

	public void setIdOrderCustomization(Long idOrderCustomization) {
		this.idOrderCustomization = idOrderCustomization;
	}//setIdOrderCustomization
	
	public OrderDetail getOrderDetail() {
	    return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
	    this.orderDetail = orderDetail;
	}

	@Override
	public String toString() {
		return "OrderCustomization [idOrderCustomization=" + idOrderCustomization + ", value=" + value + ", extraPrice="
				+ extraPrice + ", customizationType=" + customizationType + ", orderDetail=" + orderDetail + "]";
	}//toString

	
}//Class OrderCustomization
