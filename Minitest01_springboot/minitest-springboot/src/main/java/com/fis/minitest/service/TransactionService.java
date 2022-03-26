package com.fis.minitest.service;

import com.fis.minitest.entity.Transaction;
import com.fis.minitest.model.TransactionForm;

public interface TransactionService {
	Transaction doTransaction(TransactionForm transactionForm);
}
