package com.universalcopy.p_integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customizationType")
public class CustomizationType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idCustomizationType;
	@Column(nullable = false)
	private String name;
	
	public CustomizationType(String name) {
		super();
		this.name = name;
	}//Constructor

	public CustomizationType() {
	}//Constructor vacío
	
	public Long getIdCustomizationType() {
		return idCustomizationType;
	}//getIdCustomizationType

	public String getName() {
		return name;
	}//getName

	public void setName(String name) {
		this.name = name;
	}//setName

	@Override
	public String toString() {
		return "CustomizationType [idCustomizationType=" + idCustomizationType + ", name=" + name + "]";
	}//toString
	
}//Class CustomizationType
