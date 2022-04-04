package com.fis.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fis.project.dto.CriminalCaseDTO;
import com.fis.project.entity.CriminalCase;
import com.fis.project.entity.Detective;
import com.fis.project.service.CriminalCaseService;
import com.fis.project.service.DetectiveService;
import com.fis.project.util.CaseStatus;
import com.fis.project.util.CaseType;
import com.fis.project.util.ConvertEnum;

@RestController
@RequestMapping("/criminal-case")
public class CriminalCaseController{
	@Autowired
	private CriminalCaseService criminalCaseService;
	
	@Autowired
	private DetectiveService detectiveService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getCriminalById(@PathVariable long id){
	 return ResponseEntity.ok(criminalCaseService.findById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCriminalCase(@RequestBody CriminalCaseDTO caseDTO){
		CaseStatus caseStatus = ConvertEnum.valueOfIgnoreCase(CaseStatus.class, caseDTO.getStatus());
		CaseType caseType = ConvertEnum.valueOfIgnoreCase(CaseType.class, caseDTO.getType());
		CriminalCase criminalCase = CriminalCase.builder()
				.type(caseType)
				.status(caseStatus)
				.note(caseDTO.getNote())
				.shortDescription(caseDTO.getShortDescription())
				.detailedDescription(caseDTO.getDetailedDescription())
				.number(caseDTO.getNumber())
				.build();
		return ResponseEntity.ok(criminalCaseService.create(criminalCase));							
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateCriminalCase(@PathVariable long id,@RequestBody CriminalCaseDTO caseDTO){
		CriminalCase criminalCase = criminalCaseService.findById(id);
		CaseStatus caseStatus = ConvertEnum.valueOfIgnoreCase(CaseStatus.class, caseDTO.getStatus());
		CaseType caseType = ConvertEnum.valueOfIgnoreCase(CaseType.class, caseDTO.getType());
		criminalCase.setNote(caseDTO.getNote());
		criminalCase.setNumber(caseDTO.getNumber());
		criminalCase.setShortDescription(caseDTO.getShortDescription());
		criminalCase.setDetailedDescription(caseDTO.getDetailedDescription());
		criminalCase.setType(caseType);
		criminalCase.setStatus(caseStatus);
		return ResponseEntity.ok(criminalCaseService.update(criminalCase));
	}
	
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id){
		criminalCaseService.deleteById(id);
		return ResponseEntity.ok("Delete case with id:" + id);
	}
	
	@GetMapping("/set-lead-detective")
	public ResponseEntity<?> setLeadDetective(@RequestParam long criminalCaseId, @RequestParam long detectiveId){
		CriminalCase criminalCase = criminalCaseService.findById(criminalCaseId);
		Detective detective = detectiveService.findById(detectiveId);
		return ResponseEntity.ok(criminalCaseService.setLeadDetective(criminalCase, detective));
	}
	
	@GetMapping("/assign-detective")
	public ResponseEntity<?> assignDetective(@RequestParam long criminalCaseId, @RequestParam long detectiveId){
		CriminalCase criminalCase = criminalCaseService.findById(criminalCaseId);
		Detective detective = detectiveService.findById(detectiveId);
		return ResponseEntity.ok(criminalCaseService.assignDetective(criminalCase, detective));
	}
	
	//endpoint to list of criminal cases with the specified case status(Rank: CHIEF_INSPECTOR)
	@GetMapping("/find-status")
	public ResponseEntity<?> findBySpecifiedCaseStatus(@RequestParam(required = true) String status){
		CaseStatus caseStatus = ConvertEnum.valueOfIgnoreCase(CaseStatus.class, status);
		return ResponseEntity.ok(criminalCaseService.findByCriminalCaseStatus(caseStatus));
	}
	
	//endpoint to list of criminal cases of the specified username (Rank: INSPECTOR)
	@GetMapping("/find-username")
	public ResponseEntity<?> findBySpecifiedUsername(@RequestParam(required = true) String username){
		return ResponseEntity.ok(criminalCaseService.findByUsername(username));
	}
}
