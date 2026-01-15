package com.universalcopy.p_integrador.model;

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
import jakarta.persistence.Table;

@Entity
@Table(name="orderDetail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idOrderDetail;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double unitPrice;
	
	@ManyToOne
	@JoinColumn(name="idOrders")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;

	@OneToMany(mappedBy = "orderDetail", cascade = CascadeType.ALL)
	private List<OrderCustomization> orderCustomization;
	
	public OrderDetail(Integer quantity, Double unitPrice) {
		super();
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}//Constructor

	public OrderDetail() {
	}//Constructor vacío
	
	public Long getIdOrderDetail() {
		return idOrderDetail;
	}//getIdOrderDetail

	public Integer getQuantity() {
		return quantity;
	}//getQuantity

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}//setQuantity

	public Double getUnitPrice() {
		return unitPrice;
	}//getUnitPrice

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}//setUnitPrice

	public Order getOrder() {
		return order;
	}//getOrder

	public void setOrder(Order order) {
		this.order = order;
	}//setOrder

	public Product getProduct() {
		return product;
	}//getProduct

	public void setProduct(Product product) {
		this.product = product;
	}//setProduct

	@Override
	public String toString() {
		return "OrderDetail [idOrderDetail=" + idOrderDetail + ", quantity=" + quantity + ", unitPrice=" + unitPrice
				+ ", order=" + order + ", product=" + product + "]";
	}//toString
	
	
}//Class OrderDetail
