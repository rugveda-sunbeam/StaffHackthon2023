package com.app.service;

import java.util.List;

import com.app.dto.AddCourseDTO;
import com.app.dto.CourseDTO;
import com.app.dto.EditCourseDTO;
import com.app.dto.EvaluationScheduleDTO;

public interface CourseService {
	CourseDTO addCourse(AddCourseDTO courseDTO);

	CourseDTO updateCourse(EditCourseDTO courseDTO);

	void deleteCourse(Long courseId);

	CourseDTO getCourseById(Long id);

	List<CourseDTO> getAllCourses();
	
    List<EvaluationScheduleDTO> getMarksEntrySummary(Long courseId, Long subjectId);

}
