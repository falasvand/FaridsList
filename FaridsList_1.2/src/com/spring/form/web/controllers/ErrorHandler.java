package com.spring.form.web.controllers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	@ExceptionHandler(AccessDeniedException.class)
	public String handleAccessException(AccessDeniedException e){
		
		return "denied";
	}
}
