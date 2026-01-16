package com.universalcopy.p_integrador.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final JwtService jwtService;

	public SecurityConfig(JwtService jwtService) {
		this.jwtService = jwtService;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		JwtFilter jwtFilter = new JwtFilter(jwtService);

		return http

				.csrf(csrf -> csrf.disable())

				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

				.authorizeHttpRequests(auth -> auth

						// publico
						.requestMatchers(HttpMethod.POST, "/api/login").permitAll()
						.requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/customers/register").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/orders").permitAll()

						// usuariolog
						.requestMatchers(HttpMethod.POST, "/api/orders/**").hasAnyRole("USER", "ADMIN")

						// admin
						.requestMatchers(HttpMethod.POST, "/api/products/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT, "/api/products/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE, "/api/products/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.POST, "/api/categories/**").hasRole("ADMIN")

						.anyRequest().permitAll())

				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
