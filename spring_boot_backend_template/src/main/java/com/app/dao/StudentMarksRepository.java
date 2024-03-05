package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.StudentMarks;

public interface StudentMarksRepository extends JpaRepository<StudentMarks,Long> {

	List<StudentMarks> findByStudentId(Long studentId);

}
