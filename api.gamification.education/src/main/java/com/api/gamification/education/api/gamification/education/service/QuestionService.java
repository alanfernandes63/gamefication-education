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
	
	public Question saveQuestion(Question question) {
		return questionRepository.save(question);
	}
	
	public List<Question> listAllQuestions(Teacher teacher){
		return questionRepository.findByTeacher(teacher);
	}
	
	public Question getQuestion(long id) {
		return questionRepository.getOne(id);
	}
	
	public void updateQuestion(Question question) {
		questionRepository.save(question);
	}
	
	public List<Question> geQuestions() {
		return questionRepository.findAll();
	}
	
	public void deleteQuestion(long id) {
		questionRepository.deleteById(id);
	}
}
