package com.fis.ecommerce.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.ecommerce.entity.OrderDetail;
import com.fis.ecommerce.repo.OrderDetailRepo;
import com.fis.ecommerce.service.OrderDetailService;

@Service
public class OrderDetailServiceImp implements OrderDetailService {
	@Autowired
	private OrderDetailRepo orderDetailRepo;

	@Override
	public OrderDetail findById(long id) {
		return orderDetailRepo.findById(id).orElse(null);
	}

}
