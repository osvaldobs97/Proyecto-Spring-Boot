package com.universalcopy.p_integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.Order;
import com.universalcopy.p_integrador.repository.OrderRepository;

@Service
public class OrderService {
private final OrderRepository repository;

@Autowired
public OrderService(OrderRepository repository) {
	this.repository = repository;
}//Constructor

public List<Order> getOrders(){
	return repository.findAll();
}//getOrders

public Order getOrder(long id) {
	return repository.findById(id).orElseThrow(
			()-> new IllegalArgumentException("La orden con el id[" + id + "] no existe")
				);
	}//getOrder
public Order createOrder(Order order) {
    return repository.save(order);
	}//createOrder

public Order updateOrder(Long id, Order order) {
    Order existingOrder = getOrder(id);

    existingOrder.setStatus(order.getStatus());
    existingOrder.setMethod(order.getMethod());
    existingOrder.setTotalAmount(order.getTotalAmount());
    existingOrder.setPaymentDate(order.getPaymentDate());
    existingOrder.setCreatedAt(order.getCreatedAt());
    existingOrder.setCustomer(order.getCustomer());

    return repository.save(existingOrder);
	}//updateOrder

public void deleteOrder(Long id) {
    if (!repository.existsById(id)) {
        throw new IllegalArgumentException(
                "La orden con el id [" + id + "] no existe");
    }
    	repository.deleteById(id);
	}//deleteOrder


}//Class OrderService
