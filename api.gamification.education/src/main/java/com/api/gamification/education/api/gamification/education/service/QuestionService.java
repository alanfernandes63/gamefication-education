package com.api.gamification.education.api.gamification.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gamification.education.api.gamification.education.model.Question;
import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.repository.QuestionRepository;


@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	
	public void saveQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public List<Question> listAllQuestions(Teacher teacher){
		
		//listar por professor
		return questionRepository.findByTeacher(teacher);
		//return null;
	}
	
	public List<Question> geQuestions() {
		return questionRepository.findAll();
	}
	
	public void deleteQuestion(long id) {
		questionRepository.deleteById(id);
	}
}
