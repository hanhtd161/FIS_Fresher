package com.fis.project.service.imp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.project.entity.Detective;
import com.fis.project.exception.AppException;
import com.fis.project.repo.DetectiveRepo;
import com.fis.project.service.DetectiveService;

@Service
public class DetectiveServiceImp implements DetectiveService {
	
	@Autowired
	private DetectiveRepo detectiveRepo;

	@Override
	public Detective findById(long id) {
		return detectiveRepo.findById(id).orElseThrow(()-> new AppException("301","Detective Id Not Found"));
	}

	@Override
	public Detective createDetective(Detective detective) {
		return detectiveRepo.save(detective);
	}

	@Override
	public Detective updateDetective(Detective detective) {
		detective.setModifiedAt(LocalDateTime.now());
		return detectiveRepo.save(detective);
	}

	@Override
	public void deleteById(long id) {
		findById(id);
		detectiveRepo.deleteById(id);
	}

}
