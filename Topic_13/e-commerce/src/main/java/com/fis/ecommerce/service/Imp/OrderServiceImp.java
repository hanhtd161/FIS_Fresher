package com.fis.ecommerce.service.Imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ecommerce.entity.Order;
import com.fis.ecommerce.entity.OrderDetail;
import com.fis.ecommerce.entity.Product;
import com.fis.ecommerce.exception.OrderIdNotFoundException;
import com.fis.ecommerce.repo.OrderRepo;
import com.fis.ecommerce.service.OrderService;

@Service
public class OrderServiceImp implements OrderService{
	@Autowired
	private OrderRepo orderRepo;
	
	@Override
	public Order createOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order findOrderById(long orderId) {
		return orderRepo.findById(orderId).orElseThrow(()-> new OrderIdNotFoundException("Order Id Not Found!"));
	}

	@Override
	public Order addProductToOrder(long orderId,Product product, int quantity) {
		Order order = findOrderById(orderId);
		Optional<OrderDetail> optionalDetail = order.getOrderDetails().stream().filter(o -> o.getProduct().getId() == product.getId()).findAny();
		if(optionalDetail.isPresent()) {
			int exQuantity = optionalDetail.get().getQuantity();
			optionalDetail.get().setQuantity(exQuantity + quantity);
		} else {
			OrderDetail orderDetail = new OrderDetail(product, quantity, product.getPrice());
			order.addOrderDetail(orderDetail);
		}
		order.calculateTotalPrice();
		return orderRepo.save(order);
	}

	@Override
	public Order removeOrderDetail(long orderId, OrderDetail orderDetail) {
		Order order = findOrderById(orderId);
		order.removeOrderDetail(orderDetail);
		order.calculateTotalPrice();
		return orderRepo.save(order);
	}

}
