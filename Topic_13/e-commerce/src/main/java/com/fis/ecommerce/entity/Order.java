package com.fis.ecommerce.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private double totalPrice;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "order",fetch = FetchType.EAGER)
	private Set<OrderDetail> orderDetails = new HashSet<OrderDetail>();
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	private Date date;
	
	public void addOrderDetail(OrderDetail orderDetail) {
		this.orderDetails.add(orderDetail);
		orderDetail.setOrder(this);
	}
	
	public void removeOrderDetail(OrderDetail orderDetail) {
		this.orderDetails.remove(orderDetail);
		orderDetail.setOrder(null);
	}
	
	public void calculateTotalPrice() {
		this.totalPrice = orderDetails.stream().map(OrderDetail::calculatePrice).mapToDouble(Double::valueOf).sum();
	}
	
}
