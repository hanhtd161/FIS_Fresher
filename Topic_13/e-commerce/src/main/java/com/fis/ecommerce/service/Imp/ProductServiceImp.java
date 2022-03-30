package com.fis.ecommerce.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ecommerce.entity.Product;
import com.fis.ecommerce.exception.ProductIdNotFoundException;
import com.fis.ecommerce.repo.ProductRepo;
import com.fis.ecommerce.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;

	@Override
	public Product createOrUpdateProduct(Product product) {
		return productRepo.save(product);
	}

	@Override
	public void deleteProductById(long productId) {
		findProductById(productId);
		productRepo.deleteById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product findProductById(long productId) {
		return productRepo.findById(productId).orElseThrow(() -> new ProductIdNotFoundException("Product Id not found!"));
	}

}
