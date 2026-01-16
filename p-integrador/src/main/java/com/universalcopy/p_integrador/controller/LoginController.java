package com.universalcopy.p_integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.universalcopy.p_integrador.config.JwtService;
import com.universalcopy.p_integrador.controller.dto.Token;
import com.universalcopy.p_integrador.model.Customer;
import com.universalcopy.p_integrador.service.CustomerService;
import jakarta.servlet.ServletException;


@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://3.22.223.95:5500", methods = {RequestMethod.POST})
public class LoginController {

    private final CustomerService service;
    private final JwtService jwtService;

    @Autowired
    public LoginController(CustomerService service, JwtService jwtService) {
        this.service = service;
        this.jwtService = jwtService;
    }

    @PostMapping
    public Token ingresar(@RequestBody Customer customer) throws ServletException {

        Customer dbCustomer = service.validateCustomer(customer);

        if (dbCustomer == null) {
            throw new ServletException("Credenciales incorrectas");
        }

        String token = jwtService.generateToken(
                dbCustomer.getEmail(),
                dbCustomer.getRole().name()
        );

        return new Token(token);
    }

}

