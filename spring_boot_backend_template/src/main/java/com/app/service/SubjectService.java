package com.app.service;

import java.util.List;

import com.app.dto.AddSubjectDTO;
import com.app.dto.SubjectDTO;
import com.app.entities.Subject;

public interface SubjectService {
	SubjectDTO saveSubject(AddSubjectDTO subject);

	List<SubjectDTO> getAllSubjects();

	SubjectDTO getSubjectById(Long id);

	

}
