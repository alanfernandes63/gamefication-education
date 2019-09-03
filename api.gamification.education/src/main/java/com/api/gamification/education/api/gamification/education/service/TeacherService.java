package com.api.gamification.education.api.gamification.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	public void saveTeacher(Teacher teacher) {
		
		BCryptPasswordEncoder crypter = new BCryptPasswordEncoder();
		
		String lastPassword = teacher.getPassword();
		teacher.setPassword(crypter.encode(lastPassword));
		
		 teacherRepository.save(teacher);
	}
	
	public Teacher getTeacher(long id) {
		return teacherRepository.findById(id);
	}
	
	public Teacher getUserNameTeacher(String userName) {
		return teacherRepository.findByUserName(userName);
	}
	
	public Teacher deleteTeacher(long id) {
		Teacher teacher = teacherRepository.getOne(id);
		if(teacher != null) {
			teacherRepository.deleteById(id);
			return teacher;
		}
		else
			return null;
	}
}
