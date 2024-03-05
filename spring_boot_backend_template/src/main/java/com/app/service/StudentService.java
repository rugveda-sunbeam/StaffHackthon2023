package com.app.service;

import java.util.List;

import com.app.dto.AddStudentDTO;
import com.app.dto.StudentDTO;

public interface StudentService {
	List<StudentDTO> getAllStudents();

	StudentDTO getStudentById(Long studentId);

	StudentDTO createStudent(AddStudentDTO studentDTO);

	void updateStudent(Long studentId, StudentDTO studentDTO);

	void deleteStudent(Long studentId);
}
