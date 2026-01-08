package com.universalcopy.p_integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universalcopy.p_integrador.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
