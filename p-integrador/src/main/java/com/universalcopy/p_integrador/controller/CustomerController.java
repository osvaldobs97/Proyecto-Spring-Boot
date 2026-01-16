package com.universalcopy.p_integrador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.universalcopy.p_integrador.controller.dto.ChangePassword;
import com.universalcopy.p_integrador.model.Customer;
import com.universalcopy.p_integrador.service.CustomerService;

@RestController
@RequestMapping(path= "/api/customers")
@CrossOrigin(origins = "http://3.22.223.95:5500", methods = {RequestMethod.POST})
public class CustomerController {
	
	private final CustomerService service;
	
	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}//Constructor
	
	@GetMapping
	public List<Customer> getCustomers(){
		return service.getCustomers();
	}//getCustomer
	
	@GetMapping("/{customerid}")
	public Customer getCustomer(@PathVariable("customerid") long id) {
		return service.getCustomer(id);
	}//getCustomer
	
	@PostMapping("/register")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}//postCustomer
	
	@DeleteMapping("/{customerid}")
	public Customer deleteCustomer(@PathVariable("customerid") long id) {
		return service.deleteCustomer(id);
	}//DeleteCustomer
	
	
	@PutMapping("/{customerid}")
	public Customer updateCustomer(@PathVariable("customerid") long id,
			@RequestBody ChangePassword changePassword) {
		return service.updateCustomer(id, changePassword);
	}//updateCustomer

}//ClassCustomerController
