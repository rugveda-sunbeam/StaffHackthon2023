package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "course")
public class Course extends BaseEntity {
	@Column
	private String courseName;
	@Column
	private int duration;
	
	
}
