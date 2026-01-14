package com.universalcopy.p_integrador.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.universalcopy.p_integrador.controller.dto.ChangePassword;
import com.universalcopy.p_integrador.model.Customer;
import com.universalcopy.p_integrador.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}//Constructor
	
	public List<Customer> getCustomers(){
		return repository.findAll();
	}//getCustomers
	
	public Customer getCustomer(long id) {
		return repository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("El usuario con el id[" + id + "] no existe")
				);
	}//getCustomer
		
	public Customer addCustomer(Customer customer) {
		Optional<Customer> user = repository.findByEmail(customer.getEmail());
		if(user.isEmpty()) {
			customer.setPassword(encoder.encode(customer.getPassword()));
			repository.save(customer);
			return customer; 
		}
		return null;
	}//addCustomer
	
	public Customer deleteCustomer(long id) {
		Customer tmp = null;
		if(repository.existsById(id)) {
			tmp = repository.findById(id).get();
			repository.deleteById(id);
		}
		return tmp;
	}//deleteCustomer
	
	public Customer updateCustomer(long id, ChangePassword changePassword) {
		Customer tmp = null;
			if(repository.existsById(id)) {
				Customer user = repository.findById(id).get();
				if(encoder.matches(changePassword.getPassword(), user.getPassword())) {
					user.setPassword(encoder.encode(changePassword.getNpassword()));
					repository.save(user);
					tmp = user;
				}//ifId
			}
					return tmp;
			}//updateUsuario
	
	
	public Customer validateCustomer(Customer customer) {
	    Optional<Customer> usr = repository.findByEmail(customer.getEmail());
	    if (usr.isPresent()) {
	        Customer user = usr.get();

	        if (encoder.matches(customer.getPassword(), user.getPassword())) {
	            return user; 
	        }
	    }
	    return null;
	}

	  
	  
	  
	
	
}//classCustomerService
