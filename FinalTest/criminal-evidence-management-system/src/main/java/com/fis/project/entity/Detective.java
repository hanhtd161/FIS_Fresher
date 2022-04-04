package com.fis.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fis.project.util.EmploymentStatus;
import com.fis.project.util.Rank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Detective extends AbstractEntity {
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	@Exclude
	private Person person;
	
	private String badgeNumber;
	
	@Column(name = "rank_detective")
	
	@Enumerated(EnumType.STRING)
	private Rank rank;
	
	private Boolean armed;
	
	@Enumerated(EnumType.STRING)
	private EmploymentStatus status;
	
	@ManyToMany(mappedBy = "assigned")
	@JsonIgnore
	@Exclude
	private Set<CriminalCase> criminalCases = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "detective")
	@JsonIgnore
	@Exclude
	private Set<TrackEntry> trackEntries = new HashSet<>();
	
	
}
