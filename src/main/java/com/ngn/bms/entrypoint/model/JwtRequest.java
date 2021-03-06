package com.ngn.bms.entrypoint.model;

import java.io.Serializable;


public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	private String userId;
	private String password;

	//need default constructor for JSON Parsing
	public JwtRequest(){}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}