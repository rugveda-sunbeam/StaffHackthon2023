package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.SubjectRepository;
import com.app.dto.CourseDTO;
import com.app.dto.EvaluationScheduleDTO;
import com.app.entities.CourseSubject;
import com.app.entities.Subject;
import com.app.service.CourseService;
import com.app.service.CourseSubjectService;
import com.app.service.EvaluationScheduleService;
import com.app.service.SubjectService;

@RestController
@RequestMapping("/coco")
public class CocoController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private CourseSubjectService courseSubjectService;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private EvaluationScheduleService evaluationScheduleService;

	@GetMapping("/courses")
	public ResponseEntity<List<CourseDTO>> getAllCourses() {
		List<CourseDTO> courses = courseService.getAllCourses();
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	// Endpoint to get all subjects for a course
	@GetMapping("/courses/{courseId}/subjects")
	public ResponseEntity<List<CourseSubject>> getAllSubjectsForCourse(@PathVariable Long courseId) {
		List<CourseSubject> subjects = courseSubjectService.getAllSubjectsForCourse(courseId);
		return new ResponseEntity<>(subjects, HttpStatus.OK);
	}

	@PostMapping("/allocate-marks-entry-task")
	public String allocateMarksEntryTask(@RequestBody EvaluationScheduleDTO evaluationScheduleDTO) {
		try {
			// Find the subject based on subjectId
			Subject subject = subjectRepository.findById(evaluationScheduleDTO.getSubjectId()).orElseThrow(
					() -> new RuntimeException("Subject not found with id: " + evaluationScheduleDTO.getSubjectId()));

			// Allocate marks entry task
			evaluationScheduleService.saveEvaluationSchedule(evaluationScheduleDTO);

			return "Marks entry task allocated successfully.";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error allocating marks entry task: " + e.getMessage();
		}
	}

	@GetMapping("/courses/{courseId}/subjects/{subjectId}/marks-entry-summary")
	public ResponseEntity<?> getMarksEntrySummary(@PathVariable Long courseId, @PathVariable Long subjectId) {
		List<EvaluationScheduleDTO> marksEntrySummary = evaluationScheduleService.getMarksEntrySummary(subjectId);
		return new ResponseEntity<>(marksEntrySummary, HttpStatus.OK);
	}

	@PostMapping("/courses/{courseId}/subjects/{subjectId}/groups/{groupId}/approve-marks-entry")
	public ResponseEntity<?> approveMarksEntry(@PathVariable Long courseId, @PathVariable Long subjectId,
			@PathVariable String groupId) {
		try {
			// Logic to approve marks entry for the group
			evaluationScheduleService.approveMarksEntryForGroup(subjectId, groupId);
			return new ResponseEntity<>("Marks entry for group " + groupId + " approved successfully.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error approving marks entry for group " + groupId + ": " + e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
