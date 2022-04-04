package com.fis.project.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fis.project.entity.Evidence;
import com.fis.project.exception.AppException;
import com.fis.project.repo.EvidenceRepo;
import com.fis.project.service.imp.EvidenceServiceImp;

@SpringBootTest
public class EvidenceServiceTest {
	@Mock
	private EvidenceRepo evidenceRepo;
	
	@InjectMocks
	private EvidenceServiceImp evidenceService;
	
	@Test
	public void testCreate() {
		Evidence evidence = new Evidence();
		evidence.setId(1L);
		when(evidenceRepo.save(evidence)).thenReturn(evidence);
		Evidence testEvidence = evidenceService.create(evidence);
		assertThat(evidenceRepo.save(evidence).equals(testEvidence));
	}
	
	@Test
	public void testUpdate() {
		Evidence evidence = new Evidence();
		evidence.setId(1L);
		when(evidenceRepo.save(evidence)).thenReturn(evidence);
		Evidence testEvidence = evidenceService.update(evidence);
		assertThat(evidenceRepo.save(evidence).equals(testEvidence));
	}
	
	@Test
	public void testFindByid() {
		Evidence evidence = new Evidence();
		evidence.setId(1L);
		Optional<Evidence> optional = Optional.of(evidence);
		when(evidenceRepo.findById(1L)).thenReturn(optional);
		when(evidenceRepo.findById(2L)).thenThrow(new AppException("201", "Evidence Id not Found!"));
		assertThrows(AppException.class, ()-> evidenceService.findById(2L));
		assertThat(evidenceService.findById(1L).equals(evidence));
	}
	
	@Test
	public void testDelete() {
		Evidence evidence = new Evidence();
		evidence.setId(1L);
		evidenceService.deleteById(1L);
		verify(evidenceRepo,times(1)).deleteById(1L);
	}
}
