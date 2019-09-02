package com.api.gamification.education.api.gamification.education.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.service.TeacherService;

@RestController
@RequestMapping(value="/api")
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@PostMapping(value="/teacher")
	public void saveTeacher(@RequestBody Teacher teacher) {
		teacherService.saveTeacher(teacher);
	}
	
	@GetMapping(value="/teacher/{id}")
	public Teacher getTeacher(@PathVariable(value="id") long id) {
		return teacherService.getTeacher(id);
	}
	
	@DeleteMapping(value="teacher/{id}")
	public ResponseEntity deleteTeacher(@PathVariable(value="id") long id) {
		
		Teacher teacher = teacherService.deleteTeacher(id);
		if(teacher != null)
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}

}
