package com.api.gamification.education.api.gamification.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.gamification.education.api.gamification.education.model.Admin;
import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.model.UserType;
import com.api.gamification.education.api.gamification.education.repository.AdminRepository;
import com.api.gamification.education.api.gamification.education.service.TeacherService;


@SpringBootApplication
public class Application {
	@Autowired
	TeacherService teacherService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			/*Admin admin = new Admin();
			admin.setName("admin");
			admin.setUserName("admin");
			admin.setPassword("admin");
			admin.setUserType(UserType.ADMIN);
			adminRepository.save(admin);*/
			
			Teacher teacher = new Teacher();
			teacher.setName("teacher");
			teacher.setUserName("teacher");
			teacher.setPassword("teacher");
			teacher.setUserType(UserType.TEACHER);
			teacherService.saveTeacher(teacher);
			
		};
	}

}
