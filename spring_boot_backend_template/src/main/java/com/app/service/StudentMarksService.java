package com.app.service;

import java.util.List;

import com.app.dto.AddStudentMarksDTO;
import com.app.dto.StudentMarksDTO;

public interface StudentMarksService {
	StudentMarksDTO saveStudentObtainMarks(AddStudentMarksDTO studentMarksDTO);
    StudentMarksDTO getStudentObtainMarksById(Long id);
	List<StudentMarksDTO> getStudentMarksByStudentId(Long studentId);

}
