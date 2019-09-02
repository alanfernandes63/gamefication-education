package com.api.gamification.education.api.gamification.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	public void saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}
	
	public Teacher getTeacher(long id) {
		return teacherRepository.findById(id);
	}
}
