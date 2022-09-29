package com.example.demo.exceptions;

public class ResorceNotFoundException extends RuntimeException {
	
	
	public static final long serialVersionUD =1L;
	
	public ResorceNotFoundException(String message)
	{
		super(message);
	}
	

}
