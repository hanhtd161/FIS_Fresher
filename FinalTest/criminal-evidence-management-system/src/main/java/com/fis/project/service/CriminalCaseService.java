package com.fis.project.service;

import java.util.List;

import com.fis.project.entity.CriminalCase;
import com.fis.project.entity.Detective;
import com.fis.project.util.CaseStatus;

public interface CriminalCaseService {
	CriminalCase create(CriminalCase criminalCase);
	CriminalCase update(CriminalCase criminalCase);
	CriminalCase findById(long criminalCaseId);
	void deleteById(long criminalCaseId);
	CriminalCase setLeadDetective(CriminalCase criminalCase,Detective detective);
	CriminalCase assignDetective(CriminalCase criminalCase,Detective detective);
	List<CriminalCase> findByCriminalCaseStatus(CaseStatus caseStatus);
	List<CriminalCase> findByUsername(String username);
}
