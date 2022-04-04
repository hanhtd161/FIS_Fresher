package com.fis.project.service;

import java.util.List;

import com.fis.project.entity.Evidence;

public interface EvidenceService {
	Evidence findById(long id);
	Evidence create(Evidence evidence);
	Evidence update(Evidence evidence);
	void deleteById(long id);
	List<Evidence> findByCriminalNumber(String criminalNumber);
}
