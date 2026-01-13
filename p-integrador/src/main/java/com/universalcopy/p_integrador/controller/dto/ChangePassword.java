package com.universalcopy.p_integrador.controller.dto;


public class ChangePassword {
	private String password;
	private String npassword;
	
	public ChangePassword(String password, String npassword) {
		super();
		this.password = password;
		this.npassword = npassword;
	}//constructor
	
	

	public ChangePassword() {
	
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNpassword() {
		return npassword;
	}

	public void setNpassword(String npassword) {
		this.npassword = npassword;
	}

	@Override
	public String toString() {
		return "ChangePassword [password=" + password + ", npassword=" + npassword + "]";
	}
	
	
	
	
	
	
	
}//class
