package com.fis.ecommerce.service;

import com.fis.ecommerce.entity.Order;
import com.fis.ecommerce.entity.OrderDetail;
import com.fis.ecommerce.entity.Product;

public interface OrderService {
	Order createOrder(Order order);
	Order findOrderById(long orderId);
	Order addProductToOrder(long orderId, Product product,int quantity);
	Order removeOrderDetail(long orderId, OrderDetail orderDetail);
}
