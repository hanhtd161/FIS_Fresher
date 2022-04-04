package com.fis.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.project.dto.ErrorMessage;
import com.fis.project.dto.PersonDTO;
import com.fis.project.entity.Person;
import com.fis.project.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createPerson(@RequestBody PersonDTO personDTO){
		if(personService.existPersonUsername(personDTO.getUsername())) {
			return ResponseEntity.badRequest().body(new ErrorMessage("403","Username has existed"));
		}
		Person person = new Person();
		person.setFirstName(personDTO.getFirstName());
		person.setLastName(personDTO.getLastName());
		person.setUsername(personDTO.getUsername());
		person.setPassword(personDTO.getPassword());
		person.setHiringDate(personDTO.getHiringDate());
		return ResponseEntity.ok(personService.createPerson(person));
	}
}
