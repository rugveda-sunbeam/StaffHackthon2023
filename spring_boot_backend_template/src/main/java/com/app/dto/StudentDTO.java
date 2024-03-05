package com.app.dto;

import com.app.entities.Course;
import com.app.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
	private Long id;
	private User user;
	private Course course;
	private String group;
}
