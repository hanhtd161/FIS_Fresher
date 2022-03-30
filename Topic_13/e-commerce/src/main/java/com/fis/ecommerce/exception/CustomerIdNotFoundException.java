package com.fis.ecommerce.exception;

public class CustomerIdNotFoundException extends AppException {

	private static final long serialVersionUID = 1L;

	public CustomerIdNotFoundException(String message) {
		super(message);
	}
	
}
