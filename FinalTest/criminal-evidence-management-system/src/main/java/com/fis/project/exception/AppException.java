package com.fis.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;
	

}
