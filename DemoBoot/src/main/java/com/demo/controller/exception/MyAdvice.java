package com.demo.controller.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyAdvice {

	@ExceptionHandler
	public ResponseEntity<String> handleNoSuchElement(NoSuchElementException noSuchElementException){
		
		return new ResponseEntity<String>("No Element Exist for this...",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmptyElementException.class)
	public ResponseEntity<String> handleEmptyException(EmptyElementException emptyElementException){
		
		return new ResponseEntity<String>("Null value, please check...",HttpStatus.NOT_FOUND);
	}
	
}
