package com.fis.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fis.project.dto.DetectiveDTO;
import com.fis.project.entity.Detective;
import com.fis.project.entity.Person;
import com.fis.project.service.DetectiveService;
import com.fis.project.service.PersonService;
import com.fis.project.util.ConvertEnum;
import com.fis.project.util.EmploymentStatus;
import com.fis.project.util.Rank;

@RestController
@RequestMapping("/detective")
public class DetectiveController {
	
	@Autowired
	private DetectiveService detectiveService;
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getDetectiveById(@PathVariable long id){
		return ResponseEntity.ok(detectiveService.findById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createDetective(@RequestBody DetectiveDTO detectiveDTO){
		Person person = personService.findById(detectiveDTO.getPersonId());
		Rank rank = ConvertEnum.valueOfIgnoreCase(Rank.class, detectiveDTO.getRank());
		EmploymentStatus status = ConvertEnum.valueOfIgnoreCase(EmploymentStatus.class, detectiveDTO.getStatus());
		Detective detective = new Detective();
		detective.setPerson(person);
		detective.setStatus(status);
		detective.setRank(rank);
		detective.setArmed(detectiveDTO.getArmed());
		detective.setBadgeNumber(detectiveDTO.getBadgeNumber());
		return ResponseEntity.ok(detectiveService.createDetective(detective));
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<?> updateDetective(@PathVariable long id,@RequestBody DetectiveDTO detectiveDTO){
		Person person = personService.findById(detectiveDTO.getPersonId());
		Rank rank = ConvertEnum.valueOfIgnoreCase(Rank.class, detectiveDTO.getRank());
		EmploymentStatus status = ConvertEnum.valueOfIgnoreCase(EmploymentStatus.class, detectiveDTO.getStatus());
		Detective detective = detectiveService.findById(id);
		detective.setPerson(person);
		detective.setStatus(status);
		detective.setRank(rank);
		detective.setArmed(detectiveDTO.getArmed());
		detective.setBadgeNumber(detectiveDTO.getBadgeNumber());
		return ResponseEntity.ok(detectiveService.updateDetective(detective));
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<?> deleteDetective(@PathVariable long id){
		detectiveService.deleteById(id);
		return ResponseEntity.ok("Delete detective with id" + id);
	}
}
