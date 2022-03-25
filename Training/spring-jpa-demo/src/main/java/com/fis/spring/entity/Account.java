package com.fis.spring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Table(name = "acount")
@Data
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long accountId;
	
	@Column(name = "account_no")
	@JsonProperty("account_no")
	private String accountNo;
	
	@Column(name = "card_no")
	@JsonProperty("card_no")
	private String cardNo;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "amount")
	private long amount;
	
	@Column(name = "issued_date")
	private Date issuedDate;
	
	@Column(name = "update_date")
	private Date updateDate;
}
