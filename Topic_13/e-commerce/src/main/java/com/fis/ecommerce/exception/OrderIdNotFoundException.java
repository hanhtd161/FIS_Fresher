package com.fis.ecommerce.exception;

public class OrderIdNotFoundException extends AppException {

	private static final long serialVersionUID = 1L;

	public OrderIdNotFoundException(String message) {
		super(message);
	}
	
}
