package com.fis.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ecommerce.entity.Customer;
import com.fis.ecommerce.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createNewCustomer(@RequestBody @Valid Customer customer){
		customerService.createCustomer(customer);
		return ResponseEntity.ok("A new customer is created");
	}
}
