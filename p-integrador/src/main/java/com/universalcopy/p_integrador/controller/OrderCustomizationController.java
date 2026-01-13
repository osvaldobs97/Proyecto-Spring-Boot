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

import com.universalcopy.p_integrador.model.OrderCustomization;
import com.universalcopy.p_integrador.service.OrderCustomizationService;

@RestController
@RequestMapping(path = "/api/orderCustomization")
public class OrderCustomizationController {

	private final OrderCustomizationService service;
	
	@Autowired
	public OrderCustomizationController(OrderCustomizationService service) {
		this.service = service;
	}//constructor
	
	@GetMapping
	public List<OrderCustomization> getOrdersCustomization(){
		return service.getOrdersCustomization();
	}//getOrdersCustomization
	
	@GetMapping("/{ordercustomizationid}")
	public OrderCustomization getOrderCustomization(@PathVariable("ordercustomizationid")long id) {
	return service.getOrderCustomization(id);	
	}//getOrderCustomization

    @PostMapping
    public OrderCustomization createOrderCustomization(
            @RequestBody OrderCustomization orderCustomization) {
        return service.createOrderCustomization(orderCustomization);
    }//createOrderCustomization

    @PutMapping("/{ordercustomizationid}")
    public OrderCustomization updateOrderCustomization(
            @PathVariable("ordercustomizationid") Long id,
            @RequestBody OrderCustomization orderCustomization) {
        return service.updateOrderCustomization(id, orderCustomization);
    }//updateOrderCustomization

    @DeleteMapping("/{ordercustomizationid}")
    public void deleteOrderCustomization(
            @PathVariable("ordercustomizationid") Long id) {
        service.deleteOrderCustomization(id);
    }//deleteOrderCustomization
	
	
}//class