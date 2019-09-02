package com.api.gamification.education.api.gamification.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gamification.education.api.gamification.education.model.Question;
import com.api.gamification.education.api.gamification.education.service.QuestionService;
import com.api.gamification.education.api.gamification.education.service.TeacherService;

@RestController
@RequestMapping(value="/api")
public class QuestionCotroller {
	@Autowired
	QuestionService questionService;
	
	@Autowired
	TeacherService teacheService;
	
	@GetMapping(value="/questions/idTeacher")
	public List<Question> listAllQuestions(@PathVariable(value="idTeacher") long idTeacher){
		return questionService.listAllQuestions(idTeacher);
	}
	
	
	@PostMapping(value="/questions/{idTeacher}")
	public void saveQuestion(@PathVariable long idTeacher,@RequestBody Question question) {
		question.setTeacher(teacheService.getTeacher(idTeacher));
		questionService.saveQuestion(question);
	}

}
