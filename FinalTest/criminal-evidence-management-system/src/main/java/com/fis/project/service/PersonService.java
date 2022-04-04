package com.fis.project.service;

import com.fis.project.entity.Person;

public interface PersonService {
	Person findById(long id);
	Person findByUsername(String username);
	Person createPerson(Person person);
	Boolean existPersonUsername(String username);
}
