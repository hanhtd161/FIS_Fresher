package com.fis.project.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.project.entity.CriminalCase;
import com.fis.project.exception.AppException;
import com.fis.project.repo.CriminalCaseRepo;
import com.fis.project.service.imp.CriminalCaseServiceImp;

@SpringBootTest
public class CriminalCaseServiceTest {
	@Mock
	private CriminalCaseRepo criminalCaseRepo;
	
	@InjectMocks
	private CriminalCaseServiceImp criminalCaseService;
	
	
	@Test
	public void testCreate() {
		CriminalCase criminalCase = new CriminalCase();
		criminalCase.setId(1L);
		criminalCase.setNote("New");
		when(criminalCaseRepo.save(criminalCase)).thenReturn(criminalCase);
		CriminalCase testCriminalCase = criminalCaseService.create(criminalCase);
		assertThat(criminalCaseRepo.save(criminalCase).equals(testCriminalCase));
	}
	
	@Test
	public void testUpdate() {
		CriminalCase criminalCase = new CriminalCase();
		criminalCase.setId(1L);
		criminalCase.setModifiedAt(LocalDateTime.now());
		when(criminalCaseRepo.save(criminalCase)).thenReturn(criminalCase);
		CriminalCase testCriminalCase = criminalCaseService.update(criminalCase);
		assertThat(criminalCaseRepo.save(criminalCase).equals(testCriminalCase));
	}
	
	@Test
	public void testFindByid() {
		CriminalCase criminalCase = new CriminalCase();
		criminalCase.setId(1L);
		criminalCase.setNote("New");
		Optional<CriminalCase> optional = Optional.of(criminalCase);
		when(criminalCaseRepo.findById(1L)).thenReturn(optional);
		when(criminalCaseRepo.findById(2L)).thenThrow(new AppException("101", "CriminalCase Id not Found!"));
		assertThrows(AppException.class, ()-> criminalCaseService.findById(2L));
		assertThat(criminalCaseService.findById(1L).equals(criminalCase));
	}
	
	@Test
	public void testDelete() {
		CriminalCase criminalCase = new CriminalCase();
		criminalCase.setId(1L);
		criminalCase.setNote("New");
		criminalCaseService.deleteById(1L);
		verify(criminalCaseRepo,times(1)).deleteById(1L);
	}
	
}
