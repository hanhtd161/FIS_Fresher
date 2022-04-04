package com.fis.project.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private LocalDateTime hiringDate;
}
