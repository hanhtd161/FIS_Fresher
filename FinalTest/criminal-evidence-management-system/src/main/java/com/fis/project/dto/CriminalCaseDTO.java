package com.fis.project.dto;

import lombok.Data;

@Data
public class CriminalCaseDTO {
	private String number;
	private String type;
	private String shortDescription;
	private String detailedDescription;
	private String status;
	private String note;
}
