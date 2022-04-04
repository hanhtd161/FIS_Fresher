package com.fis.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.project.entity.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long>{
	Optional<Person> findByUsername(String username);
}
