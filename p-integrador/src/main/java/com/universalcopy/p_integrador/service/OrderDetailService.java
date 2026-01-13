package com.universalcopy.p_integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.OrderDetail;
import com.universalcopy.p_integrador.repository.OrderDetailRepository;


@Service
public class OrderDetailService {

	private final OrderDetailRepository repository;
	
@Autowired
public OrderDetailService(OrderDetailRepository repository) {
	this.repository = repository;
	}//constructor

public List<OrderDetail> getOrdersDetail(){
	return repository.findAll();
	}//getOrdersDetail

public OrderDetail getOrderDetail(long id) {
	return repository.findById(id).orElseThrow(
			()-> new IllegalArgumentException("El detalle de la orden con id [" + id + "] no existe")
			);
	}//getOrderDetail

public OrderDetail createOrderDetail(OrderDetail orderDetail) {
    return repository.save(orderDetail);
	}//createOrderDetail

public OrderDetail updateOrderDetail(Long id, OrderDetail orderDetail) {
    OrderDetail existingOrderDetail = getOrderDetail(id);

    existingOrderDetail.setQuantity(orderDetail.getQuantity());
    existingOrderDetail.setUnitPrice(orderDetail.getUnitPrice());
    existingOrderDetail.setOrder(orderDetail.getOrder());
    existingOrderDetail.setProduct(orderDetail.getProduct());

    return repository.save(existingOrderDetail);
	}//updateOrderDetail

public void deleteOrderDetail(Long id) {
    OrderDetail orderDetail = getOrderDetail(id);
    repository.delete(orderDetail);
	}//deleteOrderDetail 


}//ClassOrderDetails
