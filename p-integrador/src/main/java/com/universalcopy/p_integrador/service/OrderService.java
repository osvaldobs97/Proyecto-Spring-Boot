package com.universalcopy.p_integrador.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.Order;
import com.universalcopy.p_integrador.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}
	
	public Order getOrder(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order no existe"));
	}

	public Order createOrder(Order order) {
	    order.setStatus("CREATED");
	    order.setCreatedAt(LocalDateTime.now());
	    return orderRepository.save(order);
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}
}
