package com.fis.minitest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionForm {
	private long fromAccountId;
	private long toAccountId;
	private double amount;
	private String content;
}
