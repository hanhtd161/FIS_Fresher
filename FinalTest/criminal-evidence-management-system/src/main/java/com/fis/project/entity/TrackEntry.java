package com.fis.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fis.project.util.TrackAction;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Exclude;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class TrackEntry extends AbstractEntity {
	
	private LocalDateTime date;
	
	@Enumerated(EnumType.STRING)
	private TrackAction action;
	
	private String reason;
	
	@ManyToOne
	@JoinColumn(name = "evidence_id")
	@Exclude
	private Evidence evidence;
	
	@ManyToOne
	@JoinColumn(name = "detective_id")
	@Exclude
	private Detective detective;
}
