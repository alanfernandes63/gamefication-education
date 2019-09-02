package com.api.gamification.education.api.gamification.education.repository;


import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gamification.education.api.gamification.education.model.Question;
import com.api.gamification.education.api.gamification.education.model.Teacher;


//@NamedQuery(name="QuestionRepository.findallTeacher",query="SELECT q QUESTION q WHERE q.teacher.id = :teacherId")
public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	List<Question> findByTeacher(Teacher idTeacher);

}
