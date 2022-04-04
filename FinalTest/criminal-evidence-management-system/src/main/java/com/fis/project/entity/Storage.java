package com.fis.project.entity;

import java.util.Set;


import javax.persistence.Entity;
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
public class Storage extends AbstractEntity{
	private String name;
	private String localtion;
	
	@OneToMany(mappedBy = "storage")
	@JsonIgnore
	@Exclude
	private Set<Evidence> evidenceSet;
}
