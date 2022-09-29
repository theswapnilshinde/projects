package com.application.blog.model;

public class JWTResponce {
	
	public String token;

	public JWTResponce(String token) {
		super();
		this.token = token;
	}

	public JWTResponce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JWTResponce [token=" + token + "]";
	}
	
	

}
