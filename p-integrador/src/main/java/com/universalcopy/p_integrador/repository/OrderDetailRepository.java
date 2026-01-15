package com.universalcopy.p_integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universalcopy.p_integrador.model.Order;
import com.universalcopy.p_integrador.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	List<OrderDetail> findByOrder(Order order);


}
