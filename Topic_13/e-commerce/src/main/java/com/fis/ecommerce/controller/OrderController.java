package com.fis.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fis.ecommerce.entity.Customer;
import com.fis.ecommerce.entity.Order;
import com.fis.ecommerce.entity.OrderDetail;
import com.fis.ecommerce.entity.Product;
import com.fis.ecommerce.repo.OrderDetailRepo;
import com.fis.ecommerce.service.CustomerService;
import com.fis.ecommerce.service.OrderService;
import com.fis.ecommerce.service.ProductService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderDetailRepo orderDetailRepo;
	
	@GetMapping("/create")
	public ResponseEntity<?> createNewOrder(@RequestParam(required = true) long customerId){
		Customer customer = customerService.findCustomerById(customerId);
		Order order = new Order();
		customer.addOrder(order);
		return ResponseEntity.ok(orderService.createOrder(order));
	}
	
	@GetMapping("/add-product")
	public ResponseEntity<?> addProductToOrder(@RequestParam long orderId, @RequestParam long productId, @RequestParam int quantity){
		Product product = productService.findProductById(productId);
		return ResponseEntity.ok(orderService.addProductToOrder(orderId, product, quantity));
	}
	
	@GetMapping("/remove-OrderDetail/{orderDetailId}")
	public ResponseEntity<?> removeOrderDetail(@RequestParam long orderId, @PathVariable long orderDetailId){
		OrderDetail orderDetail = orderDetailRepo.findById(orderDetailId).orElse(null);
		if(orderDetail == null) {
			return ResponseEntity.badRequest().body("OrderDetails Id not found!");
		}
		return ResponseEntity.ok(orderService.removeOrderDetail(orderId, orderDetail));
	}
	
}
