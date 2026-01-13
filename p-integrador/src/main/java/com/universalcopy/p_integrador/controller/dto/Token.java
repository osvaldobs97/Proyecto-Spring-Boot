package com.universalcopy.p_integrador.controller.dto;

public class Token {
	private String accessToken;
	
	public Token(String accessToken) {
		super();
		this.accessToken = accessToken;
	}//constructor
	
	public String getAccessToken() {
		return accessToken;
	}//accessToken
}//ClassToken

