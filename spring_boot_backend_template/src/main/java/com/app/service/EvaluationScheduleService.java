package com.app.service;

import java.util.List;

import com.app.dto.EvaluationScheduleDTO;
import com.app.entities.EvaluationSchedule;

public interface EvaluationScheduleService {
	EvaluationScheduleDTO saveEvaluationSchedule(EvaluationScheduleDTO evaluationSchedule);

	EvaluationScheduleDTO getEvaluationScheduleById(Long id);

	List<EvaluationScheduleDTO> getAllSchedules();

	List<EvaluationScheduleDTO> getMarksEntrySummary(Long subjectId);

	void approveMarksEntryForGroup(Long subjectId, String groupId);

}
