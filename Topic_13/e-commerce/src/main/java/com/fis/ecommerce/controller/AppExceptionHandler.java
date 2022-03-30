package com.fis.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fis.ecommerce.exception.AppException;
import com.fis.ecommerce.exception.CustomerIdNotFoundException;
import com.fis.ecommerce.exception.ProductIdNotFoundException;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		return ResponseEntity.badRequest().body(details);
	}
	
	@ExceptionHandler({CustomerIdNotFoundException.class,ProductIdNotFoundException.class})
	public ResponseEntity<?> handleAppException(AppException ex){
		return ResponseEntity.badRequest().body(ex.getMessage());
	}
}
