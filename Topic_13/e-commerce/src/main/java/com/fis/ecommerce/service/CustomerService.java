package com.fis.ecommerce.service;

import com.fis.ecommerce.entity.Customer;

public interface CustomerService {
	Customer createCustomer(Customer customer);
	Customer findCustomerById(long customerId);
}
