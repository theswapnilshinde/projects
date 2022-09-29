package com.example.demo.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// handle specific exception  sending coustom exception to client this class Resorce Not Found Exception class used for 
	// this exce[ption class handle all the Project Exceptions int projects
	@ExceptionHandler(ResorceNotFoundException.class)
	public ResponseEntity<?> HandlerRescorcenotFoundException
	(ResorceNotFoundException resorceNotFoundExceptrion,WebRequest webRequest)
	{
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(),
				resorceNotFoundExceptrion.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	
	// handle Global Exception 
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> HandleGlobalException
	(Exception exceptrion,WebRequest webRequest)
	{
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(),
				exceptrion.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<?> HandleAPIException
	(APIException apiExceptrion,WebRequest webRequest)
	{
		
		ErrorDetails errorDetails = new ErrorDetails(new Date(),
				apiExceptrion.getMessage(),webRequest.getDescription(false));
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
		
	}

}
