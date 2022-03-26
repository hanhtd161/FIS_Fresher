package com.fis.minitest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "transaction_date")
	private Date transactionDate;
	
	private double amount;
	
	private int status;
	
	private String content;
	
	@Column(name = "error_reason")
	private String errorReason;
	
	@ManyToOne
	@JoinColumn(name = "fromAccountId")
	@EqualsAndHashCode.Exclude
	private Account fromAccount;
	
	@ManyToOne
	@JoinColumn(name = "toAccountId")
	@EqualsAndHashCode.Exclude
	private Account toAccount;
	
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
		fromAccount.getFromTransactions().add(this);
	}
	
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
		fromAccount.getToTransactions().add(this);
	}
}
