package com.fis.minitest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.minitest.model.AccountCreateForm;
import com.fis.minitest.model.AccountUpdateForm;
import com.fis.minitest.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAllSortedAccount(){
		return ResponseEntity.ok(accountService.getAllAccountsSortedByAccountName());
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createAccount(@Valid @RequestBody AccountCreateForm account) {
		if(accountService.existByAccountName(account.getAccountName())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Account Number existed");
		}
		return ResponseEntity.ok(accountService.saveAccount(account));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> updateAccount(@Valid @RequestBody AccountUpdateForm account){
		return ResponseEntity.ok(accountService.updateAccount(account));
	}
}
