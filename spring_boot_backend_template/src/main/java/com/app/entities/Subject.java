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
@Table(name = "subject")
public class Subject extends BaseEntity {
	@Column(name = "subject_name", nullable = false)
	private String subjectName;

	@Column(name = "theory_max_marks", nullable = false)
	private int theoryMaxMarks;

	@Column(name = "lab_max_marks", nullable = false)
	private int labMaxMarks;

	@Column(name = "ia1_max_marks", nullable = false)
	private int ia1MaxMarks;

	@Column(name = "ia2_max_marks", nullable = false)
	private int ia2MaxMarks;

}
