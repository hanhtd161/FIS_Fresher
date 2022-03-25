package com.fis.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.spring.entity.Account;
import com.fis.spring.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.save(account));
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.update(account));
	}
	
	@GetMapping("/delete/{deleteId}")
	public ResponseEntity<?> delete(@PathVariable long deleteId) {
		accountService.deleteById(deleteId);
		return ResponseEntity.ok(deleteId);
	}
	
	@GetMapping("/get/{accountId}")
	public ResponseEntity<?> get(@PathVariable long accountId) {
		return ResponseEntity.ok(accountService.findById(accountId));
	}
}
