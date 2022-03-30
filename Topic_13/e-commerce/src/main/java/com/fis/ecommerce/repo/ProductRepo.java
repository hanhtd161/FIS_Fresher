package com.fis.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fis.ecommerce.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
