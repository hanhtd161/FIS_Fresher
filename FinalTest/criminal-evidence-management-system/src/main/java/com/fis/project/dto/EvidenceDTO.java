package com.fis.project.dto;

import lombok.Data;

@Data
public class EvidenceDTO {
	private String number;
	private String itemName;
	private String notes;
	private Boolean archived;
}
