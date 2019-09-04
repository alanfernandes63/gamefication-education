package com.api.gamification.education.api.gamification.education.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.model.UserType;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

	Teacher findById(long id);
	Teacher findByUserName(String userName);
	
	@Query("SELECT u FROM Teacher u WHERE u.userType = :userType")
	List<Teacher> findAllTeachers(UserType userType);
}
