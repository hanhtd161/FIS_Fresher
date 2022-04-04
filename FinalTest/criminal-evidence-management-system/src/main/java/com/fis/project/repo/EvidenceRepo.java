package com.fis.project.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.project.entity.Evidence;

@Repository
public interface EvidenceRepo extends JpaRepository<Evidence, Long>{
	List<Evidence> findByCriminalCase_Number(String caseNumber);
}
