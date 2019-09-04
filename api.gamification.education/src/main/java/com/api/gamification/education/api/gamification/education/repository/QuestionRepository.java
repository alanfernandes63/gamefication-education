package com.api.gamification.education.api.gamification.education.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gamification.education.api.gamification.education.model.Question;
import com.api.gamification.education.api.gamification.education.model.Teacher;

public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	List<Question> findByTeacher(Teacher idTeacher);

}
