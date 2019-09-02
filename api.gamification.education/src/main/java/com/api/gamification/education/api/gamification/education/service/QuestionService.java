package com.api.gamification.education.api.gamification.education.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gamification.education.api.gamification.education.model.Question;
import com.api.gamification.education.api.gamification.education.repository.QuestionRepository;


@Service
public class QuestionService {
	
	@Autowired
	QuestionRepository questionRepository;
	
	public void saveQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public List<Question> listAllQuestions(long idTeacher){
		
		//listar por professor
		return questionRepository.findAll();
	}
	
	public List<Question> geQuestions() {
		return questionRepository.findAll();
	}
	
	public void deleteQuestion(long id) {
		questionRepository.deleteById(id);
	}
}
