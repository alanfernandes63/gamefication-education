package com.api.gamification.education.api.gamification.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gamification.education.api.gamification.education.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	Teacher findById(long id);
	Teacher findByUserName(String userName);
}
