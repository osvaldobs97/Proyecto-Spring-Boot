package com.universalcopy.p_integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.universalcopy.p_integrador.model.Customer;
import com.universalcopy.p_integrador.model.Order;
import com.universalcopy.p_integrador.service.CustomerService;
import com.universalcopy.p_integrador.service.OrderService;

@RestController
@RequestMapping(path="/api/orders")
public class OrdersController {
	
	private final OrderService service;
    private final CustomerService customerService;

    @Autowired
    public OrdersController(OrderService orderService, CustomerService customerService) {
        this.service = orderService;
        this.customerService = customerService;
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order,
            @RequestParam(name = "customerId") Long customerId){
        Customer customer = customerService.getCustomer(customerId);
        order.setCustomer(customer);
        return service.createOrder(order);
    }
	
	@GetMapping
	public List<Order>getOrders(){
		return service.getOrders();
	}//getOrders
	
	@GetMapping("/{orderid}")
	public Order getOrder(@PathVariable("orderid") long id) {
		return service.getOrder(id);
	}//getOrder
	
	
    @DeleteMapping("/{orderid}")
    public void deleteOrder(@PathVariable Long id) {
        service.deleteOrder(id);
    }//DeleteOrder
	

}//class 