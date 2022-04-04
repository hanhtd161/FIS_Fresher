package com.fis.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Person extends AbstractEntity {
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private LocalDateTime hiringDate;
	
}
