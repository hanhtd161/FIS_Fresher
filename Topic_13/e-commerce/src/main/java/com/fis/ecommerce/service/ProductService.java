package com.fis.ecommerce.service;

import java.util.Date;
import java.util.List;

import com.fis.ecommerce.entity.Product;

public interface ProductService {
	Product createOrUpdateProduct(Product product);
	void deleteProductById(long productId);
	List<Product> getAllProducts();
	Product findProductById(long productId);
	Product findBestSellingProduct(Date startDate, Date endDate);
}
