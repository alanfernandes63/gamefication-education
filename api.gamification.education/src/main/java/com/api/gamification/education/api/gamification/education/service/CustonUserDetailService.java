package com.api.gamification.education.api.gamification.education.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.model.UserType;
import com.api.gamification.education.api.gamification.education.repository.TeacherRepository;


//@Component
//public class CustonUserDetailService implements UserDetailsService{

	
	//private final TeacherRepository teacherRepository;
	/*
	@Autowired
	public CustonUserDetailService(TeacherRepository teacherRepository) {
		// TODO Auto-generated constructor stub
		this.teacherRepository = teacherRepository;
	
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Teacher teacher = Optional
		.ofNullable(teacherRepository
		.findByUserName(username))
		.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> authorityListTecher = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN","ROLE_TEACHER");
		if(teacher.getUserType() == UserType.TEACHER) {
		return new User(teacher.getUserName(),teacher.getPassword(),authorityListTecher);
		}
		else
			return null;
	}*/

//}
