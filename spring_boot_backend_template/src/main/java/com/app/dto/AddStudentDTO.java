package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStudentDTO {
	private Long userId;
	private Long courseId;
	private String group;
}
