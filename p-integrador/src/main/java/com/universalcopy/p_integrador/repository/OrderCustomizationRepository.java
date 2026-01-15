package com.universalcopy.p_integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universalcopy.p_integrador.model.OrderCustomization;
import com.universalcopy.p_integrador.model.OrderDetail;

@Repository
public interface OrderCustomizationRepository extends JpaRepository<OrderCustomization, Long>{
	List<OrderCustomization> findByOrderDetail(OrderDetail detail);

}
