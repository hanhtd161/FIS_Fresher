package com.fis.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.ecommerce.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
