package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AddStudentMarksDTO;
import com.app.dto.EvaluationScheduleDTO;
import com.app.dto.StudentDTO;
import com.app.dto.SubjectDTO;
import com.app.service.EvaluationScheduleService;
import com.app.service.StudentMarksService;
import com.app.service.StudentService;
import com.app.service.SubjectService;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StudentMarksService studentMarksService;

	@Autowired
	private EvaluationScheduleService evaluationScheduleService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
		// Get all students
		List<StudentDTO> students = studentService.getAllStudents();
		return ResponseEntity.ok(students);
	}

	@GetMapping("/subjects")
	public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
		// Get all subjects
		List<SubjectDTO> subjects = subjectService.getAllSubjects();
		return ResponseEntity.ok(subjects);
	}

	@GetMapping("/evaluationSchedules")
	public ResponseEntity<List<EvaluationScheduleDTO>> getEvaluationSchedules() {
		// Get evaluation schedules
		List<EvaluationScheduleDTO> schedules = evaluationScheduleService.getAllSchedules();
		return ResponseEntity.ok(schedules);
	}

	  @PostMapping("/enterMarks")
	    public ResponseEntity<String> enterMarks(@RequestBody AddStudentMarksDTO studentMarksDTO) {
	        try {
	            studentMarksService.saveStudentObtainMarks(studentMarksDTO);
	            return ResponseEntity.ok("Marks entered successfully");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error entering marks: " + e.getMessage());
	        }
	    }
}
