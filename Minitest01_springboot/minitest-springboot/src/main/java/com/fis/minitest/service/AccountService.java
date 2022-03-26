package com.fis.minitest.service;

import java.util.List;

import com.fis.minitest.entity.Account;
import com.fis.minitest.model.AccountCreateForm;
import com.fis.minitest.model.AccountUpdateForm;


public interface AccountService {
	List<Account> getAllAccountsSortedByAccountName();
	Account saveAccount(AccountCreateForm account);
	Account updateAccount(AccountUpdateForm account);
	void deleteAccountById(long accountId);
	Account findById(long accountId);
	boolean existByAccountName(String accountNumber);
}
