package com.fis.minitest.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.minitest.entity.Account;
import com.fis.minitest.exception.AccountIdNotFoundException;
import com.fis.minitest.model.AccountCreateForm;
import com.fis.minitest.model.AccountUpdateForm;
import com.fis.minitest.repo.AccountRepo;
import com.fis.minitest.service.AccountService;
import com.fis.minitest.util.CONSTANT;

@Service
public class AccountServiceImp implements AccountService{
	
	@Autowired
	private AccountRepo accountRepo;

	@Override
	public List<Account> getAllAccountsSortedByAccountName() {
		return accountRepo.findByOrderByAccountNameAsc();
	}

	@Override
	public Account saveAccount(AccountCreateForm account) {
		Account newAccount = new Account();
		newAccount.setAccountName(account.getAccountName());
		newAccount.setAccountNumber(account.getAccountNumber());
		newAccount.setBalance(CONSTANT.ACCOUNT_START_BALANCE);
		newAccount.setStatus(CONSTANT.ACCOUNT_STATUS_HIEU_LUC);
		return accountRepo.save(newAccount);
	}

	@Override
	public Account updateAccount(AccountUpdateForm account) {
		Account findAccount = findById(account.getId());
		findAccount.setAccountName(account.getAccountName());
		findAccount.setStatus(account.getStatus());
		return accountRepo.save(findAccount);
	}

	@Override
	public void deleteAccountById(long accountId) {
		Account deleteAccount = findById(accountId);
		accountRepo.delete(deleteAccount);
	}
	
	public Account findById(long id) {
		return accountRepo.findById(id).orElseThrow(() -> new AccountIdNotFoundException("Account Id not Found!"));
	}
	
	public boolean existByAccountName(String accountNumber) {
		return accountRepo.findByAccountNumber(accountNumber).isPresent();
	}

}
