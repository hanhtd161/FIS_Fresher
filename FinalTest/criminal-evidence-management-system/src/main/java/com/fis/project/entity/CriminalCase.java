package com.fis.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fis.project.util.CaseStatus;
import com.fis.project.util.CaseType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode.Exclude;


@Entity(name = "criminal_case")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CriminalCase extends AbstractEntity {
	private String number;
	
	@Enumerated(EnumType.STRING)
	private CaseType type;
	
	private String shortDescription;
	
	private String detailedDescription;
	
	@Enumerated(EnumType.STRING)
	private CaseStatus status;
	
	private String note;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "criminalCase")
	@JsonIgnore
	@Builder.Default
	@Exclude
	private Set<Evidence> evidenceSet = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name = "lead_investigator")
	private Detective leadInvestigator;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "working_detective_case",
			joinColumns = @JoinColumn(name = "case_id"),
			inverseJoinColumns = @JoinColumn(name = "detective_id")
			)
	@Builder.Default
	@Exclude
	private Set<Detective> assigned = new HashSet<>();
	
	
}
