package com.universalcopy.p_integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.universalcopy.p_integrador.model.Order;
import com.universalcopy.p_integrador.service.OrderService;

@RestController
@RequestMapping(path="/api/orders")
public class OrdersController {
	
	private final OrderService service;
	
	@Autowired
	public OrdersController(OrderService service) {
		this.service = service;
	}
	
	@GetMapping
	public List<Order>getOrdenes(){
		return service.getOrders();
	}//getOrders
	
	@GetMapping("/{orderid}")
	public Order getOrden(@PathVariable("orderid") long id) {
		return service.getOrder(id);
	}//getOrder
	
	
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }//createOrder

    @PutMapping("/{orderid}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return service.updateOrder(id, order);
    }//UpdateOrder

    @DeleteMapping("/{orderid}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }//DeleteOrder
	

}//class 
