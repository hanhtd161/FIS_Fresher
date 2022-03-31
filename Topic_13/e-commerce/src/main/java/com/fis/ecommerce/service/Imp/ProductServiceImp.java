package com.fis.ecommerce.service.Imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fis.ecommerce.entity.Product;
import com.fis.ecommerce.exception.ProductIdNotFoundException;
import com.fis.ecommerce.repo.OrderDetailRepo;
import com.fis.ecommerce.repo.ProductRepo;
import com.fis.ecommerce.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private OrderDetailRepo orderDetailRepo;

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

	@Override
	public Product findBestSellingProduct(Date startDate, Date endDate) {
		Pageable pageable = PageRequest.of(0, 1);
		return orderDetailRepo.findBestSellingProduct(startDate, endDate, pageable).get(0);
	}

}
