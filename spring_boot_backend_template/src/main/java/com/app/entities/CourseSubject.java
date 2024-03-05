package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "course_subject")
public class CourseSubject extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	@ManyToOne
	@JoinColumn(name = "subject_id", nullable = false)
	private Subject subject;

}
