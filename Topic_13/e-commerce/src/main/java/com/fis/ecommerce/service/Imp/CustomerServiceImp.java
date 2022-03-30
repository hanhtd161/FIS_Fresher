package com.fis.ecommerce.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ecommerce.entity.Customer;
import com.fis.ecommerce.exception.CustomerIdNotFoundException;
import com.fis.ecommerce.repo.CustomerRepo;
import com.fis.ecommerce.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer findCustomerById(long customerId) {
		return customerRepo.findById(customerId).orElseThrow(()-> new CustomerIdNotFoundException("Customer Id Not Found!"));
	}

}
