package com.app.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CourseDTO {
	private Long id;
	private String courseName;
	private int duration;
}
