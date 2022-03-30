package com.fis.ecommerce.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min = 3, max = 50, message = "Product name must be 3 - 50 characters")
	private String title;
	
	@Size(min = 5, max = 100, message = "Product description must be 5 - 100 characters")
	private String description;
	
	@Size(min = 1, message = "Must have atleast 1 product ")
	private int quantity;
	
	@NotBlank(message = "Price is required")
	private double price;
	
	private Date createdAt;
	
	@PrePersist
	public void createdAt() {
		this.createdAt = new Date();
	}
}
