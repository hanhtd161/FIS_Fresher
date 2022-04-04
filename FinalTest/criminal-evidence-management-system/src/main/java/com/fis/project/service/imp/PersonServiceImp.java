package com.fis.project.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.project.entity.Person;
import com.fis.project.exception.AppException;
import com.fis.project.repo.PersonRepo;
import com.fis.project.service.PersonService;

@Service
public class PersonServiceImp implements PersonService{
	
	@Autowired
	PersonRepo personRepo;

	@Override
	public Person findById(long id) {
		return personRepo.findById(id).orElseThrow(()-> new AppException("401","Person Id Not Found"));
	}

	@Override
	public Person findByUsername(String username) {
		return personRepo.findByUsername(username).orElseThrow(()-> new AppException("402", "Username Not Found"));
	}

	@Override
	public Person createPerson(Person person) {
		return personRepo.save(person);
	}

	@Override
	public Boolean existPersonUsername(String username) {
		return personRepo.findByUsername(username).isPresent();
	}

}
