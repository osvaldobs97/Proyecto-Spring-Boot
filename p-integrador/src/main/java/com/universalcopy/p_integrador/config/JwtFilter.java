package com.universalcopy.p_integrador.config;

import java.io.IOException;
import java.security.Key;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean {
	private static final String SECRET = "#Java_el_mejor_lenguaje_de_programacion_lo_quiero_mucho21#";
	
	public static Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
	
	public static Key getSigningKey() {
		return key;
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader = httpServletRequest.getHeader("Authorization");
		String method = httpServletRequest.getMethod();// GET POST PUT DELETE
		String URI = httpServletRequest.getRequestURI(); // /api/
		
		if(((method.equals("POST")) && (!URI.contains("/api/customers/"))) 
		|| ((method.equals("GET")) && (!URI.contains("/api/products/")))
		|| (method.equals("PUT")) || (method.equals("DELETE"))
		){
			
			if((authHeader == null) || (! authHeader.startsWith("Bearer "))) {
				System.out.println("1. Invalid Token");
				throw new ServletException("1.Invalid Token");
			}//authHeader
			String token = authHeader.substring(7);
			
			try {
			Claims claims = Jwts.parserBuilder()
							.setSigningKey(getSigningKey())
							.build()
							.parseClaimsJws(token).getBody();
			claims.forEach((key,value) -> System.out.println("Key[" + key + "] Value[" + value + "]")
					);
			
		}catch (ExpiredJwtException | MalformedJwtException | SignatureException e ){
			System.out.println("2. Invalid Token " + e.toString());
			throw new ServletException("2.Invalid Token");
			}//catch
		}//if
		
		chain.doFilter(request, response);
	
	}

}//class
