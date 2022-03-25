package com.fis.spring.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.spring.entity.Account;
import com.fis.spring.repository.AccountRepo;
import com.fis.spring.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public Account save(Account account) {
		//validate
		account.setIssuedDate(new Date());
		return accountRepo.save(account);
	}

	@Override
	public Account update(Account account) {
		//validate
		account.setUpdateDate(new Date());
		// ghi vao bang account_history...
		return accountRepo.save(account);
	}

	@Override
	public void deleteById(long accountId) {
		 accountRepo.deleteById(accountId);
		
	}

	@Override
	public Account findById(long accountId) {
		return accountRepo.findById(accountId).orElse(null);
	}

	@Override
	public List<Account> getByFullname(String fullname) {
		return accountRepo.getByFullname(fullname);
	}
}
