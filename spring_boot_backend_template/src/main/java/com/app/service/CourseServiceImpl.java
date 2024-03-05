package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CourseRepository;
import com.app.dto.AddCourseDTO;
import com.app.dto.CourseDTO;
import com.app.dto.EditCourseDTO;
import com.app.dto.EvaluationScheduleDTO;
import com.app.entities.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private EvaluationScheduleService evaluationScheduleService;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CourseDTO addCourse(AddCourseDTO courseDTO) {
		Course course = modelMapper.map(courseDTO, Course.class);
		course.setDuration(6);
		Course savedCourse = courseRepository.save(course);
		return modelMapper.map(savedCourse, CourseDTO.class);
	}

	@Override
	public CourseDTO updateCourse(EditCourseDTO courseDTO) {
		if (courseRepository.existsById(courseDTO.getId())) {
			Course course = modelMapper.map(courseDTO, Course.class);
			Course updatedCourse = courseRepository.save(course);
			return modelMapper.map(updatedCourse, CourseDTO.class);
		} else {
			throw new RuntimeException("Course not found with id: " + courseDTO.getId());
		}
	}

	@Override
	public void deleteCourse(Long courseId) {
		if (courseRepository.existsById(courseId)) {
			courseRepository.deleteById(courseId);
		} else {
			throw new RuntimeException("Course not found with id: " + courseId);
		}
	}

	@Override
	public List<CourseDTO> getAllCourses() {
		List<Course> courses = courseRepository.findAll();
		return courses.stream().map(course -> modelMapper.map(course, CourseDTO.class)).collect(Collectors.toList());
	}

	@Override
	public CourseDTO getCourseById(Long id) {
		Course course = courseRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Course not found with id: " + id));
		return modelMapper.map(course, CourseDTO.class);
	}

	@Override
	public List<EvaluationScheduleDTO> getMarksEntrySummary(Long courseId, Long subjectId) {
		return evaluationScheduleService.getMarksEntrySummary(subjectId);
	}
}
