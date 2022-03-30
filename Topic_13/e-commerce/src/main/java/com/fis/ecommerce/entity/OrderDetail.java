package com.fis.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	
	private int quantity;
	
	private double unitPrice;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	public double calculatePrice() {
		return this.quantity * this.unitPrice;
	}

	public OrderDetail(Product product, int quantity, double unitPrice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
}
