package com.fis.project.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.project.entity.CriminalCase;
import com.fis.project.entity.Detective;
import com.fis.project.entity.Person;
import com.fis.project.repo.CriminalCaseRepo;
import com.fis.project.util.CaseStatus;

@SpringBootTest
public class CriminalRepoTest {
	@Autowired
	private CriminalCaseRepo criminalCaseRepo;
	
	@Test
	public void testFindByStatus() {
		CriminalCase firstCriminalCase = new CriminalCase();
		firstCriminalCase.setStatus(CaseStatus.CLOSED);
		CriminalCase firstSaved =  criminalCaseRepo.save(firstCriminalCase);
		
		CriminalCase secondCriminalCase = new CriminalCase();
		secondCriminalCase.setStatus(CaseStatus.CLOSED);
		criminalCaseRepo.save(secondCriminalCase);
		
		CriminalCase thirdCriminalCase = new CriminalCase();
		thirdCriminalCase.setStatus(CaseStatus.IN_COURT);
		criminalCaseRepo.save(thirdCriminalCase);
		
		List<CriminalCase> listFoundCase = criminalCaseRepo.findByStatus(CaseStatus.CLOSED);
		
		assertThat(listFoundCase.size()==2);
		assertThat(listFoundCase.contains(firstSaved));
		
	}
	
	@Test
	public void testFindByUsername() {
		Person person1 = new Person("hanh", "tran", "hanh", "123456", LocalDateTime.now());
		Person person2 = new Person("tung", "hoang", "tung", "123456", LocalDateTime.now());
		
		Detective detective1 = new Detective();
		detective1.setPerson(person1);
		
		Detective detective2 = new Detective();
		detective2.setPerson(person2);
		
		
		CriminalCase case1 = new CriminalCase();
		case1.getAssigned().add(detective1);
		detective1.getCriminalCases().add(case1);
		
		CriminalCase case2 = new CriminalCase();
		case2.getAssigned().add(detective2);
		detective2.getCriminalCases().add(case2);
		
		CriminalCase savedCase1 = criminalCaseRepo.save(case1);
		criminalCaseRepo.save(case2);
		List<CriminalCase> listFoundCases = criminalCaseRepo.findByUsername("hanh");
		assertThat(listFoundCases.size() ==1);
		assertThat(listFoundCases.contains(savedCase1));
	}
	@AfterEach
	public void after () {
		criminalCaseRepo.deleteAll();
	}
	
}
