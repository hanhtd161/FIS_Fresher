package com.fis.minitest.service.Impl;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fis.minitest.entity.Account;
import com.fis.minitest.entity.Transaction;
import com.fis.minitest.model.TransactionForm;
import com.fis.minitest.repo.TransactionRepo;
import com.fis.minitest.service.AccountService;
import com.fis.minitest.service.TransactionService;
import com.fis.minitest.util.CONSTANT;

public class TransactionServiceImp implements TransactionService {
	
	@Autowired
	TransactionRepo transactionRepo;
	
	@Autowired
	AccountService accountService;

	@Override
	@Transactional
	public Transaction doTransaction(TransactionForm form) {
		Account fromAccount =  accountService.findById(form.getFromAccountId());
		Account toAccount =  accountService.findById(form.getToAccountId());
		Transaction transaction = new Transaction();
		transaction.setTransactionDate(new Date());
		transaction.setAmount(form.getAmount());
		transaction.setContent(form.getContent());
		transaction.setFromAccount(fromAccount);
		transaction.setToAccount(toAccount);
		if(fromAccount.getStatus() != CONSTANT.ACCOUNT_STATUS_HIEU_LUC || toAccount.getStatus() != CONSTANT.ACCOUNT_STATUS_HIEU_LUC) {
			transaction.setErrorReason("Tai khoan den hoac di khong con hieu luc");
			transaction.setStatus(CONSTANT.TRANSACTION_STATUS_FAIL);
		}
		if(fromAccount.getBalance() < form.getAmount()) {
			transaction.setErrorReason("Tai khoan nguon khong du tien");
			transaction.setStatus(CONSTANT.TRANSACTION_STATUS_FAIL);
		}
		fromAccount.setBalance(fromAccount.getBalance() - form.getAmount());
		toAccount.setBalance(toAccount.getBalance() + form.getAmount());
		transaction.setStatus(CONSTANT.TRANSACTION_STATUS_SUCCESS);
		return transactionRepo.save(transaction);
	}
	
	

}
