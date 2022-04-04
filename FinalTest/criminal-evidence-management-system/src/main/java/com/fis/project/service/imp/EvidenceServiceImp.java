package com.fis.project.service.imp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.project.entity.Evidence;
import com.fis.project.exception.AppException;
import com.fis.project.repo.EvidenceRepo;
import com.fis.project.service.EvidenceService;

@Service
public class EvidenceServiceImp implements EvidenceService{
	
	@Autowired
	private EvidenceRepo evidenceRepo;

	@Override
	public Evidence findById(long id) {
		return evidenceRepo.findById(id).orElseThrow(()-> new AppException("201","Evidence Id not found"));
	}

	@Override
	public Evidence create(Evidence evidence) {
		return evidenceRepo.save(evidence);
	}

	@Override
	public Evidence update(Evidence evidence) {
		evidence.setModifiedAt(LocalDateTime.now());
		return evidenceRepo.save(evidence);
	}

	@Override
	public void deleteById(long id) {
		evidenceRepo.delete(findById(id));
	}

	@Override
	public List<Evidence> findByCriminalNumber(String criminalNumber) {
		return evidenceRepo.findByCriminalCase_Number(criminalNumber);
	}
	
}
