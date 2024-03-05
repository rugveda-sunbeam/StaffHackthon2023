package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.CourseSubject;

@Repository
public interface CourseSubjectRepository extends JpaRepository<CourseSubject, Long> {
    List<CourseSubject> findByCourseId(Long courseId);
}