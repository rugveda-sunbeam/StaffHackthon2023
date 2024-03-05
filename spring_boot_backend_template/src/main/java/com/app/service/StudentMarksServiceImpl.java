package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.StudentMarksRepository;
import com.app.dao.StudentRepository;
import com.app.dao.SubjectRepository;
import com.app.dto.AddStudentMarksDTO;
import com.app.dto.StudentMarksDTO;
import com.app.entities.Student;
import com.app.entities.StudentMarks;
import com.app.entities.Subject;

@Service
@Transactional
public class StudentMarksServiceImpl implements StudentMarksService {
	@Autowired
	private StudentMarksRepository studentObtainMarksRepository;

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentMarksDTO getStudentObtainMarksById(Long id) {
		StudentMarks studentMarks = studentObtainMarksRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("StudentObtainMarks not found with id: " + id));
		return modelMapper.map(studentMarks, StudentMarksDTO.class);
	}

	@Override
	public List<StudentMarksDTO> getStudentMarksByStudentId(Long studentId) {
		List<StudentMarks> studentMarksEntities = studentObtainMarksRepository.findByStudentId(studentId);
		List<StudentMarksDTO> studentMarksDTOs = new ArrayList<>();

		for (StudentMarks studentMarksEntity : studentMarksEntities) {
			StudentMarksDTO studentMarksDTO = modelMapper.map(studentMarksEntity, StudentMarksDTO.class);
			studentMarksDTOs.add(studentMarksDTO);
		}

		return studentMarksDTOs;
	}

	@Override
	public StudentMarksDTO saveStudentObtainMarks(AddStudentMarksDTO studentMarksDTO) {
		StudentMarks studObtainedMarks = modelMapper.map(studentMarksDTO, StudentMarks.class);
		Long studentId = studentMarksDTO.getStudentId();
		Student student = studentRepository.findById(studentId)
				.orElseThrow(() -> new RuntimeException("Student not found")); // Assuming userRepository is your user
																				// repository
		studObtainedMarks.setStudent(student);
		Long subjectId = studentMarksDTO.getSubjectId();
		Subject subject = subjectRepository.findById(subjectId)
				.orElseThrow(() -> new RuntimeException("Subject not found"));
		studObtainedMarks.setSubject(subject);
		StudentMarks savestudObtainedMarks = studentObtainMarksRepository.save(studObtainedMarks);

		return modelMapper.map(savestudObtainedMarks,StudentMarksDTO.class);
	}
}
