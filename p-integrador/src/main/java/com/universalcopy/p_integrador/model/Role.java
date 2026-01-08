package com.universalcopy.p_integrador.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique = true, nullable = false)
	private Long idRole;
	@Column(nullable = false)
	
	private String name;
	public Role(String name) {
		super();
		this.name = name;
	}//Constructor
	
	public Long getIdRole() {
		return idRole;
	}//getIdRole
	
	public String getName() {
		return name;
	}//getName
	
	public void setName(String name) {
		this.name = name;
	}//setName

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", name=" + name + "]";
	}//toString
	
}//Class Role
