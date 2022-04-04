package com.fis.project.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.project.entity.CriminalCase;
import com.fis.project.entity.Evidence;

import com.fis.project.repo.EvidenceRepo;

@SpringBootTest
public class EvidenceRepoTest {
	@Autowired
	private EvidenceRepo evidenceRepo;
	
	
	@Test
	public void testFindByCriminalCaseNumber() {
		CriminalCase case1 = new CriminalCase();
		case1.setNumber("111");
		
		Evidence evidence1 = new Evidence();
		evidence1.setCriminalCase(case1);
		case1.getEvidenceSet().add(evidence1);
		evidenceRepo.save(evidence1);
		
		List<Evidence> list = evidenceRepo.findByCriminalCase_Number("111");
		assertThat(list.size() == 1 );
	}
	
	@AfterEach
	public void afterTest() {
		evidenceRepo.deleteAll();
	}
}
