package com.fis.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.project.dto.EvidenceDTO;
import com.fis.project.entity.Evidence;
import com.fis.project.service.EvidenceService;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {
	@Autowired
	private EvidenceService evidenceService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getById(@PathVariable long id){
		return ResponseEntity.ok(evidenceService.findById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createEvidence(@RequestBody EvidenceDTO evidenceDTO){
		Evidence evidence = new Evidence();
		evidence.setNumber(evidenceDTO.getNumber());
		evidence.setNotes(evidenceDTO.getNotes());
		evidence.setItemName(evidenceDTO.getItemName());
		evidence.setArchived(evidenceDTO.getArchived());
		return ResponseEntity.ok(evidenceService.create(evidence));
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> createEvidence(@PathVariable long id, @RequestBody EvidenceDTO evidenceDTO){
		Evidence evidence = evidenceService.findById(id);
		evidence.setNumber(evidenceDTO.getNumber());
		evidence.setNotes(evidenceDTO.getNotes());
		evidence.setItemName(evidenceDTO.getItemName());
		evidence.setArchived(evidenceDTO.getArchived());
		return ResponseEntity.ok(evidenceService.update(evidence));
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable long id){
		evidenceService.deleteById(id);
		return ResponseEntity.ok("Delete evidence with id:" + id);
	}
	
	@GetMapping("/find/{criminalNumber}")
	public ResponseEntity<?> findEvidenceBySpecifiedUsername(@PathVariable String criminalNumber){
		return ResponseEntity.ok(evidenceService.findByCriminalNumber(criminalNumber));
	} 
	
	
	
	
}
