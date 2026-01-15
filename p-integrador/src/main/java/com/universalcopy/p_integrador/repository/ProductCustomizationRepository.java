package com.universalcopy.p_integrador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universalcopy.p_integrador.model.ProductCustomization;

@Repository
public interface ProductCustomizationRepository extends JpaRepository<ProductCustomization, Long>{
	Optional<ProductCustomization> findById(Long id);
}
