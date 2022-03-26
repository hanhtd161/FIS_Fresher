package com.fis.minitest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "account_number")
	@Size(max = 12, min = 12, message = "account number must be 12 character")
	private String accountNumber;
	
	@Column(name = "account_name")
	private String accountName;
	
	private double balance;
	
	private int status;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "fromAccount")
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Set<Transaction> fromTransactions = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "toAccount")
	@EqualsAndHashCode.Exclude
	@JsonIgnore
	private Set<Transaction> toTransactions = new HashSet<>();
	
}
