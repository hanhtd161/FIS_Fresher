package com.fis.project.service;

import com.fis.project.entity.Detective;

public interface DetectiveService {
	Detective findById(long id);
	Detective createDetective(Detective detective);
	Detective updateDetective(Detective detective);
	void deleteById(long id);
}
