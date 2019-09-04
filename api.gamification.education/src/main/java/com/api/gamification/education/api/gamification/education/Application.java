package com.api.gamification.education.api.gamification.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.api.gamification.education.api.gamification.education.model.Admin;
import com.api.gamification.education.api.gamification.education.model.UserType;
import com.api.gamification.education.api.gamification.education.repository.AdminRepository;


@SpringBootApplication
public class Application {
	@Autowired
	AdminRepository adminRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
		
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Admin admin = new Admin();
			admin.setName("admin1");
			admin.setUserName("admin1");
			admin.setPassword("admin1");
			admin.setUserType(UserType.ADMIN);
			adminRepository.save(admin);
			
			
		};
	}

}
