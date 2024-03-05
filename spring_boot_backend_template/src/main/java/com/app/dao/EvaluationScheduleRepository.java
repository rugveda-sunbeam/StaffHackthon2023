package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.EvaluationSchedule;

public interface EvaluationScheduleRepository extends JpaRepository<EvaluationSchedule, Long> {

	List<EvaluationSchedule> findBySubjectId(Long subjectId);

    List<EvaluationSchedule> findBySubjectIdAndGroupvalue(Long subjectId, String groupId);


}
