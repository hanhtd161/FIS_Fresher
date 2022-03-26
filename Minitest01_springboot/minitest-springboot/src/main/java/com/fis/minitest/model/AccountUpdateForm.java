package com.fis.minitest.model;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateForm {
	
	private long id;
	
	@Size(max = 12, min = 12, message = "account number must be 12 characters")
	private String accountName;
	
	@Size(min = 0, max = 2, message = "account status is invalid")
	private int status;
}
