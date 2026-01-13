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

import com.universalcopy.p_integrador.model.OrderDetail;
import com.universalcopy.p_integrador.service.OrderDetailService;

@RestController
@RequestMapping(path = "/api/orderdetail")
public class OrderDetailsController {
	
	private final OrderDetailService service;
	
	@Autowired
	public OrderDetailsController(OrderDetailService service) {
	this.service = service;	
	}//constructor
	
	@GetMapping
	public List<OrderDetail> getOrdersDetails(){
		return service.getOrdersDetail();
	}//getOrdersDetail
	
	@GetMapping("/{orderdetailid}")
	public OrderDetail getOrderDetail(@PathVariable("orderdetailid") long id) {
	return service.getOrderDetail(id);	
	}//getOrderDetail
	
    @PostMapping
    public OrderDetail createOrderDetail(
            @RequestBody OrderDetail orderDetail) {
        return service.createOrderDetail(orderDetail);
    }//PostOrderDetail
    
    @PutMapping("/{orderdetailid}")
    public OrderDetail updateOrderDetail(
            @PathVariable("orderdetailid") Long id,
            @RequestBody OrderDetail orderDetail) {
        return service.updateOrderDetail(id, orderDetail);
    }//PutOrderDetail

    @DeleteMapping("/{orderdetailid}")
    public void deleteOrderDetail(
            @PathVariable("orderdetailid") Long id) {
        service.deleteOrderDetail(id);
    }//DeleteOrderDetail

}//classOrderdetailController
