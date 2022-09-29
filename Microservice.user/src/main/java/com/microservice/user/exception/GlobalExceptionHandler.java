package com.microservice.user.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.microservice.user.responce.ApiResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> responseEntity(ResourceNotFoundException resourceNotFoundException)
	{
		String massage = resourceNotFoundException.getMessage();
		ApiResponce apiResponce = new ApiResponce(massage,false);
		
		return new ResponseEntity<ApiResponce>(apiResponce,HttpStatus.NOT_FOUND);
		
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodNotValiException(MethodArgumentNotValidException argumentNotValidException)
	{
		Map<String,String> map = new HashMap<>();
		argumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
			String filname= ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			
			map.put(filname, message);
		});
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
		
	}

}
