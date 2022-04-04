package com.fis.project.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int version;
	
	@Column
	private LocalDateTime createdAt;
	
	@Column
	private LocalDateTime modifiedAt;
	
	@PrePersist
	public void createdAt() {
		this.createdAt = LocalDateTime.now();
	}
}
