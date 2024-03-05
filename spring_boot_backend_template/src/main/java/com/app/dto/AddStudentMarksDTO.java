package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStudentMarksDTO {
	private Long studentId; // Foreign key reference to User
	private Long subjectId; // Foreign key reference to Subject
	private int theoryMarks;
	private int labMarks;
	private int ia1Marks;
	private int ia2Marks;

}
