package com.app.service;

import java.util.List;

import com.app.dto.EvaluationScheduleDTO;
import com.app.entities.CourseSubject;

public interface CourseSubjectService {
	List<CourseSubject> getAllSubjectsForCourse(Long courseId);

    void allocateMarksEntryTask(EvaluationScheduleDTO evaluationScheduleDTO);
	
	List<EvaluationScheduleDTO> getMarksEntrySummary(Long subjectId);

    void approveMarksEntry(EvaluationScheduleDTO evaluationScheduleDTO);



}
