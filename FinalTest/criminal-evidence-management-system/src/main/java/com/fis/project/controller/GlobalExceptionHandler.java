package com.fis.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.fis.project.dto.ErrorMessage;
import com.fis.project.exception.AppException;

@RestController
public class GlobalExceptionHandler {
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleEnumException(IllegalArgumentException ex){
		return ResponseEntity.badRequest().body(new ErrorMessage("501",ex.getMessage()));
	}
	
	@ExceptionHandler(AppException.class)
	public ResponseEntity<?> handleEnumException(AppException ex){
		return ResponseEntity.badRequest().body(new ErrorMessage(ex.getCode(),ex.getMessage()));
	}
	

}
