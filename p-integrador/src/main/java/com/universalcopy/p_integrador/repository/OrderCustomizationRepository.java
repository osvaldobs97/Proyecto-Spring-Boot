package com.universalcopy.p_integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universalcopy.p_integrador.model.OrderCustomization;

@Repository
public interface OrderCustomizationRepository extends JpaRepository<OrderCustomization, Long>{

}
