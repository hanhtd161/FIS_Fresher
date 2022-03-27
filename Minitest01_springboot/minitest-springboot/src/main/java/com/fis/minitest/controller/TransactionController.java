package com.fis.minitest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.minitest.model.TransactionForm;
import com.fis.minitest.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/create")
	public ResponseEntity<?> doTransaction(@RequestBody TransactionForm form){
		return ResponseEntity.ok(transactionService.doTransaction(form));
	}
	
}
