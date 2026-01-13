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

import com.universalcopy.p_integrador.model.Customer;
import com.universalcopy.p_integrador.service.CustomerService;

@RestController
@RequestMapping(path= "/api")
public class CustomerController {
	
	private final CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}//Constructor
	
	@GetMapping("/customer/")
	public List<Customer> getCustomers(){
		return service.getCustomers();
	}//getCustomer
	
	@GetMapping("/customer/{customerid}")
	public Customer getCustomer(@PathVariable("customerid") long id) {
		return service.getCustomer(id);
	}//getCustomer
	
	@PostMapping("/customer/")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}//postCustomer
	
	@DeleteMapping("/customer/{customerid}")
	public Customer updateCustomer(@PathVariable("customerid") long id) {
		return service.deleteCustomer(id);
	}//DeleteCustomer
	
	/*
	@PutMapping("/usuarios/{userid}")
	public Customer updateCustomer(@PathVarible("customerid") long id,
			@RequestBody ChangePassword changePassword) {
		return service.updateCustomer(id, changePassword);
	}//updateCustomer
	*/
	
	

}//ClassCustomerController
