package com.universalcopy.p_integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universalcopy.p_integrador.model.OrderCustomization;
import com.universalcopy.p_integrador.repository.OrderCustomizationRepository;

@Service
public class OrderCustomizationService {

	private final OrderCustomizationRepository repository;
	
	@Autowired
	public OrderCustomizationService(OrderCustomizationRepository repository) {
		this.repository = repository;
	}//constructor
	
	public List<OrderCustomization> getOrdersCustomization(){
		return repository.findAll();
	}//getOrdersCustomization
	
	public OrderCustomization getOrderCustomization(long id) {
		return repository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("La orden personalizada con el id[" + id + "] no existe")
				);
	}//getOrderCustomization
	
    public OrderCustomization createOrderCustomization(
            OrderCustomization orderCustomization) {
        return repository.save(orderCustomization);
    }//CreateOrderCustomization

    public OrderCustomization updateOrderCustomization(
            Long id, OrderCustomization orderCustomization) {

        OrderCustomization existingCustomization = getOrderCustomization(id);
        existingCustomization.setExtraPrice(orderCustomization.getExtraPrice());
        

        return repository.save(existingCustomization);
    }//updateOrderCustomization

    public void deleteOrderCustomization(Long id) {
        OrderCustomization customization = getOrderCustomization(id);
        repository.delete(customization);
    }//deleteOrderCustomization
    
}//ClassOrderCustomization
