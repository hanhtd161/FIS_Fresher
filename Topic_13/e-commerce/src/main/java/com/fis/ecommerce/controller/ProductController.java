package com.fis.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ecommerce.entity.Product;
import com.fis.ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllProducts() {
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createNewProduct(@RequestBody @Valid Product product){
		return ResponseEntity.ok(productService.createOrUpdateProduct(product));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateProduct(@RequestBody @Valid Product product){
		Product updatedProduct = productService.findProductById(product.getId());
		updatedProduct.setTitle(product.getTitle());
		updatedProduct.setDescription(product.getDescription());
		updatedProduct.setPrice(product.getPrice());
		updatedProduct.setQuantity(product.getQuantity());
		return ResponseEntity.ok(productService.createOrUpdateProduct(updatedProduct));
	}
	
}
