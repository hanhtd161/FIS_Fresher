package com.fis.project.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.project.entity.Detective;

@Repository
public interface DetectiveRepo extends JpaRepository<Detective,Long> {
	Optional<Detective> findByPerson_Username(String username);
}
