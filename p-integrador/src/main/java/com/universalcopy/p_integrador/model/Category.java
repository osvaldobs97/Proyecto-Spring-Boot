package com.universalcopy.p_integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="category")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idCategory;
	@Column(nullable = false)
	private String name;
	
	public Category(Long idCategory, String name) {
		super();
		this.name = name;
	}//Constructor

	public Long getIdCategory() {
		return idCategory;
	}//getIdCategory

	public String getName() {
		return name;
	}//getName

	public void setName(String name) {
		this.name = name;
	}//setName

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", name=" + name + "]";
	}//toString
	
	
	
}//Class Category
