package com.fis.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Exclude;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Evidence extends AbstractEntity{
	private String number;
	private String itemName;
	private String notes;
	private Boolean archived;
	
	@ManyToOne
	@JoinColumn(name = "storage_id")
	@Exclude
	private Storage storage;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "evidence")
	@JsonIgnore
	@Exclude
	private Set<TrackEntry> trackEntries = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "case_id")
	@Exclude
	private CriminalCase criminalCase;
}
