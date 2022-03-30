package com.fis.ecommerce.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String fullname;
	
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private Set<Order> orders = new HashSet<Order>();
	
	public void addOrder(Order order){
		this.orders.add(order);
		order.setCustomer(this);
	}
}