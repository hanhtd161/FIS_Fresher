package com.fis.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ecommerce.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
