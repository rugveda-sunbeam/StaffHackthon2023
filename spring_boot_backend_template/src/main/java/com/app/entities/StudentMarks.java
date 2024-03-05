package com.app.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "student_obtain_marks")
public class StudentMarks extends BaseEntity {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id", referencedColumnName = "id")
	private Student student; // Foreign key reference to User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id", referencedColumnName = "id")
	private Subject subject; // Foreign key reference to Subject
	private int theoryMarks;
	private int labMarks;
	private int ia1Marks;
	private int ia2Marks;
}
