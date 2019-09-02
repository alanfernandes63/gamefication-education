package com.api.gamification.education.api.gamification.education.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gamification.education.api.gamification.education.model.Question;
import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.service.QuestionService;
import com.api.gamification.education.api.gamification.education.service.TeacherService;

@RestController
@RequestMapping(value="/api")
public class QuestionCotroller {
	@Autowired
	QuestionService questionService;
	
	@Autowired
	TeacherService teacheService;
	
	@GetMapping(value="/questions/{idTeacher}")
	public ResponseEntity<List<Question>> listAllQuestions(@PathVariable(value="idTeacher") long idTeacher){
		Teacher teacher = teacheService.getTeacher(idTeacher);
		questionService.listAllQuestions(teacher);
		if(teacher != null)
		return new ResponseEntity<List<Question>>(questionService.listAllQuestions(teacher),HttpStatus.BAD_REQUEST);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping(value="/questions/{idTeacher}")
	public ResponseEntity<Question> saveQuestion(@PathVariable long idTeacher,@RequestBody Question question) {
		Teacher teacher = teacheService.getTeacher(idTeacher);
		if(teacher != null) {
			question.setTeacher(teacher);
		return new ResponseEntity<Question>(questionService.saveQuestion(question),HttpStatus.CREATED);
		}
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping(value="/questions/{id}")
	public ResponseEntity deleteQuestions(@PathVariable long id) {
		
		questionService.deleteQuestion(id);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="questions/{id}")
	public ResponseEntity updateQuestion(@RequestBody Question questionUpdate,@PathVariable long id) {
		Question question = questionService.getQuestion(id);
		if(question != null) {
			Teacher teacher = question.getTeacher();
			questionUpdate.setId(question.getId());
			question = questionUpdate;
			question.setTeacher(teacher);
			questionService.updateQuestion(question);
			return new ResponseEntity(HttpStatus.OK);
		}
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
		
	
	

}