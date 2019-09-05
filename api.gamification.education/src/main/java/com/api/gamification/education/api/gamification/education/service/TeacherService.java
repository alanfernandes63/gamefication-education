package com.api.gamification.education.api.gamification.education.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.gamification.education.api.gamification.education.dto.ResponseTeacherDTO;
import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.model.UserType;
import com.api.gamification.education.api.gamification.education.repository.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository teacherRepository;
	
	public Teacher saveTeacher(Teacher teacher) {
		Teacher responseTeacher = null;
		if (getUserNameTeacher(teacher.getName()) == null) {
		
			BCryptPasswordEncoder crypter = new BCryptPasswordEncoder();
			String lastPassword = teacher.getPassword();
			teacher.setPassword(crypter.encode(lastPassword));
			
			responseTeacher = teacherRepository.save(teacher);
		}
		return responseTeacher;
	}
	
	public List<ResponseTeacherDTO> listAllTeachersDTO(){
		List<ResponseTeacherDTO> listTeacherDto = new ArrayList<ResponseTeacherDTO>();
		
		for(Teacher teacher: teacherRepository.findAll()) {
			listTeacherDto.add(ResponseTeacherDTO.transformToResponseTeacherDTO(teacher));
		}
		return listTeacherDto;
	}
	
	public ResponseTeacherDTO getTeacherDTO(long id) {
		return ResponseTeacherDTO.transformToResponseTeacherDTO(teacherRepository.findById(id));
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
	
	public Teacher updateTeacher(Teacher newTeacher) {
		
		Teacher teacher = teacherRepository.findById(newTeacher.getId());
		
		BCryptPasswordEncoder crypter = new BCryptPasswordEncoder();
		String lastPassword = newTeacher.getPassword();
		newTeacher.setPassword(crypter.encode(lastPassword));
		
		if(teacher != null) {
			
			return teacherRepository.save(newTeacher);
		}
		return null;
	}
	
	public Teacher getTeacher(long id) {
		return teacherRepository.findById(id);
	}
}
