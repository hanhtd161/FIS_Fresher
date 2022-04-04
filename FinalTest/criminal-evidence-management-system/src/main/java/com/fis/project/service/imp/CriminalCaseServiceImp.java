package com.fis.project.service.imp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.project.entity.CriminalCase;
import com.fis.project.entity.Detective;
import com.fis.project.exception.AppException;
import com.fis.project.repo.CriminalCaseRepo;
import com.fis.project.service.CriminalCaseService;
import com.fis.project.util.CaseStatus;

@Service
public class CriminalCaseServiceImp implements CriminalCaseService {
	
	@Autowired
	CriminalCaseRepo criminalCaseRepo;

	@Override
	public CriminalCase create(CriminalCase criminalCase) {
		return criminalCaseRepo.save(criminalCase);
	}

	@Override
	public CriminalCase update(CriminalCase criminalCase) {
		criminalCase.setModifiedAt(LocalDateTime.now());
		return criminalCaseRepo.save(criminalCase);
	}

	@Override
	public CriminalCase findById(long criminalCaseId) {
		return criminalCaseRepo.findById(criminalCaseId).orElseThrow(()-> new AppException("101", "CriminalCase Id not Found!"));
	}

	@Override
	public void deleteById(long criminalCaseId) {
		criminalCaseRepo.deleteById(criminalCaseId);
		
	}

	@Override
	public List<CriminalCase> findByCriminalCaseStatus(CaseStatus caseStatus) {
		return criminalCaseRepo.findByStatus(caseStatus);
	}

	@Override
	public List<CriminalCase> findByUsername(String username) {
		return criminalCaseRepo.findByUsername(username);
	}

	@Override
	public CriminalCase setLeadDetective(CriminalCase criminalCase, Detective detective) {
		criminalCase.setLeadInvestigator(detective);
		detective.getCriminalCases().add(criminalCase);
		return criminalCaseRepo.save(criminalCase);
	}

	@Override
	public CriminalCase assignDetective(CriminalCase criminalCase, Detective detective) {
		criminalCase.getAssigned().add(detective);
		detective.getCriminalCases().add(criminalCase);
		return criminalCaseRepo.save(criminalCase);
	}

	

}
