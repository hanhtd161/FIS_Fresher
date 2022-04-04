package com.fis.project.dto;

import lombok.Data;

@Data
public class DetectiveDTO {
	
	private long personId;
	
	private String badgeNumber;
	
	private String rank;
	
	private Boolean armed;
	
	private String status;
}
