package com.universalcopy.p_integrador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universalcopy.p_integrador.model.CustomizationType;

@Repository
public interface CustomizationTypeRepository extends JpaRepository<CustomizationType, Long>{
	Optional<CustomizationType> findByName(String name);
}
