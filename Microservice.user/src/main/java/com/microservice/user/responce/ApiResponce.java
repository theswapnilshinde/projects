package com.microservice.user.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
//@AllArgsConstructor
public class ApiResponce { 
	
	public String message;
	public Boolean success;
	
	public ApiResponce(String message, Boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	
	
}
