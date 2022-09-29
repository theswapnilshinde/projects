package com.application.blog;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeResource {
	
	@GetMapping("/")
	public String index()
	{
		return "Welcome to home Page";
		
	}


}
