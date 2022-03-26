package com.fis.minitest.model;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountCreateForm {
	
	@Size(max = 12, min = 12, message = "account number must be 12 characters")
	private String accountNumber;
	
	@Size(min = 5, max = 100, message = "account name must be between 5 and 100 characters")
	private String accountName;
	
	
}
