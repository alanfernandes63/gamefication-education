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

//import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.model.UserType;
//import com.api.gamification.education.api.gamification.education.repository.TeacherRepository;
import com.api.gamification.education.api.gamification.education.repository.UserRepository;


@Component
public class CustonUserDetailService implements UserDetailsService{

	
	private final UserRepository userRepository;
	
	@Autowired
	public CustonUserDetailService(UserRepository userRepository) {
		// TODO Auto-generated constructor stub
		this.userRepository = userRepository;
	
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.api.gamification.education.api.gamification.education.model.User user = Optional
		.ofNullable(userRepository
		.findByUserName(username))
		.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		List<GrantedAuthority> authorityListTecher = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_TEACHER");
		List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN");
		if(user.getUserType() == UserType.TEACHER) {
		return new User(user.getUserName(),user.getPassword(),authorityListTecher);
		}
		else if(user.getUserType() == UserType.ADMIN) {
			return new User(user.getUserName(),user.getPassword(),authorityListAdmin);
		}
			return null;
	}

}
