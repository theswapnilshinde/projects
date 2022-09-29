package com.application.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.blog.responce_payloads_Dto.ApiResponce;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)   // we get object of ResourceNotFoundException to show the exact Exception
	public ResponseEntity<ApiResponce> resourceNotoundExceptionHandler(ResourceNotFoundException resourceNotFoundException)
	{
		String message= resourceNotFoundException.getMessage();
		ApiResponce apiResponce = new ApiResponce(message,false);
		return new ResponseEntity<>(apiResponce,HttpStatus.NOT_FOUND);

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
		return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);

	}
}
