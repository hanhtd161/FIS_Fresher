package com.fis.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fis.project.entity.CriminalCase;
import com.fis.project.util.CaseStatus;

@Repository
public interface CriminalCaseRepo extends JpaRepository<CriminalCase, Long> {
	List<CriminalCase> findByStatus(CaseStatus status);
	
	@Query("Select c from criminal_case c join c.assigned d where d.person.username = :username")
	List<CriminalCase> findByUsername(String username);
}
