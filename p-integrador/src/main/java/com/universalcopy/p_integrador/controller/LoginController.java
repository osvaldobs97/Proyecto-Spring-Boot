package com.universalcopy.p_integrador.controller;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.universalcopy.p_integrador.config.JwtFilter;
import com.universalcopy.p_integrador.controller.dto.Token;
import com.universalcopy.p_integrador.model.Customer;
import com.universalcopy.p_integrador.service.CustomerService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;


@RestController
@RequestMapping(path="/api/login")
@CrossOrigin(
	    origins = "*",
	    methods = {RequestMethod.POST, RequestMethod.OPTIONS}
	)

public class LoginController {
	
	private final CustomerService service;
	@Autowired
	public LoginController(CustomerService service) {
		this.service = service;
	}
	
	
	@PostMapping
	public Token ingresar(@RequestBody Customer customer) throws ServletException {
		if(service.validateCustomer(customer)) {
			return new Token (generateToken(customer.getEmail()));
		}
		throw new ServletException("Nombre de usuario o contraseña incorrectos[" + customer.getEmail() + "]");
	}//login
	
	private String generateToken(String email) {
		Calendar calendar = Calendar.getInstance();//Fecha y hora actual
		calendar.add(Calendar.HOUR, 24); //Solo para pruebas
		return Jwts.builder().setSubject(email)
						.claim("role", "user")
						.claim("type", "client")
						.setIssuedAt(new Date())
						.setExpiration(calendar.getTime())
						.signWith(JwtFilter.getSigningKey(), SignatureAlgorithm.HS256)
						.compact();
	}//generateToken

}
