package com.api.gamification.education.api.gamification.education.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.gamification.education.api.gamification.education.model.Admin;
import com.api.gamification.education.api.gamification.education.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepository;
	
	public void saveAdmin(Admin admin) {
		adminRepository.save(admin);
	}

}
