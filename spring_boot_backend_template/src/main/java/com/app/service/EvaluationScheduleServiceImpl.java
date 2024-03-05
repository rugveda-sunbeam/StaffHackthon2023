package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.EvaluationScheduleRepository;
import com.app.dao.SubjectRepository;
import com.app.dto.EvaluationScheduleDTO;
import com.app.entities.EvaluationSchedule;

@Service
@Transactional
public class EvaluationScheduleServiceImpl implements EvaluationScheduleService {

	@Autowired
	private EvaluationScheduleRepository evaluationScheduleRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public EvaluationScheduleDTO saveEvaluationSchedule(EvaluationScheduleDTO evaluationSchedule) {
		EvaluationSchedule evalSchedule = modelMapper.map(evaluationSchedule, EvaluationSchedule.class);
		EvaluationSchedule persistESchedule = evaluationScheduleRepository.save(evalSchedule);

		return modelMapper.map(persistESchedule, EvaluationScheduleDTO.class);
	}

	@Override
	public EvaluationScheduleDTO getEvaluationScheduleById(Long id) {
		Optional<EvaluationSchedule> optionalEvaluationSchedule = evaluationScheduleRepository.findById(id);
		if (optionalEvaluationSchedule.isPresent()) {
			EvaluationSchedule evaluationSchedule = optionalEvaluationSchedule.get();
			return modelMapper.map(evaluationSchedule, EvaluationScheduleDTO.class);
		} else {
			return null; // or throw an exception, depending on your application's logic
		}
	}

	@Override
	public List<EvaluationScheduleDTO> getAllSchedules() {
		List<EvaluationSchedule> schedules = evaluationScheduleRepository.findAll();
		return schedules.stream().map(this::convertToDto).collect(Collectors.toList());
	}

	private EvaluationScheduleDTO convertToDto(EvaluationSchedule schedule) {
		return modelMapper.map(schedule, EvaluationScheduleDTO.class);
	}

	@Override
	public List<EvaluationScheduleDTO> getMarksEntrySummary(Long subjectId) {
		List<EvaluationSchedule> schedules = evaluationScheduleRepository.findBySubjectId(subjectId);
		// Convert entities to DTOs
		return schedules.stream().map(this::mapToDTO).collect(Collectors.toList());
	}

	private EvaluationScheduleDTO mapToDTO(EvaluationSchedule schedule) {
		EvaluationScheduleDTO dto = new EvaluationScheduleDTO();
		dto.setSubjectId(schedule.getSubject().getId()); // Assuming subjectId is retrieved from Subject entity
		dto.setEvaluationType(schedule.getEvaluationType());
		dto.setValidTill(schedule.getValidTill());
		dto.setGroupvalue(schedule.getGroupvalue());
		dto.setAssignedUserId(schedule.getAssignedUserId());
		return dto;
	}

	@Override
	public void approveMarksEntryForGroup(Long subjectId, String groupId) {
		// Retrieve evaluation schedules for the specified subject and group
	    List<EvaluationSchedule> schedules = evaluationScheduleRepository.findBySubjectIdAndGroupvalue(subjectId, groupId);
	

		// Implement your logic to approve marks entry for the group
		for (EvaluationSchedule schedule : schedules) {
			// Update the status or flag to mark the marks entry as approved
			schedule.setApproved(true); // Assuming there is a boolean field 'approved' in the EvaluationSchedule entity
			// You might perform other operations such as updating timestamps, etc.
		}

		// Save the updated schedules in the database
		evaluationScheduleRepository.saveAll(schedules);
	}

}
