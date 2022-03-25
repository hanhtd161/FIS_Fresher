package com.fis.spring.service;

import java.util.List;

import com.fis.spring.entity.Account;

public interface AccountService {
	Account save(Account account);
	Account update(Account account);
	void deleteById(long accountId);
	Account findById(long accountId);
	List<Account> getByFullname(String fullname);
}
