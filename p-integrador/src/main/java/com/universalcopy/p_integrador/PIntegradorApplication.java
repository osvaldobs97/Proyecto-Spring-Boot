package com.universalcopy.p_integrador;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.universalcopy.p_integrador.model.Customer;
import com.universalcopy.p_integrador.model.Role;
import com.universalcopy.p_integrador.repository.CustomerRepository;

@SpringBootApplication
public class PIntegradorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PIntegradorApplication.class, args);
	}//main

	@Bean
    CommandLineRunner initAdmin(CustomerRepository repo, PasswordEncoder encoder) {
        return args -> {

            
            if (!repo.existsByEmail("admin@admin.com")) {

                Customer admin = new Customer(
                    "Admin",
                    "0000000000",
                    "admin@admin.com",
                    encoder.encode("admin123"), null, null
                );

                admin.setRole(Role.ROLE_ADMIN);
                repo.save(admin);
            }//if
        };//crearadmin
    }
}//Class PIntegradorApplication
