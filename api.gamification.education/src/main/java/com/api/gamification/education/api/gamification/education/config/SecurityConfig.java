package com.api.gamification.education.api.gamification.education.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.api.gamification.education.api.gamification.education.service.CustonUserDetailService;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustonUserDetailService custonDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/api/v1/teacher/").hasRole("TEACHER")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(custonDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("alan")
		.password("{noop}123").roles("USER")
		.and().withUser("ADMIN").
		password("{noop}123").
		roles("USER","ADMIN");
	}*/
}
