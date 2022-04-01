package com.fis.springtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeVO {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
}
