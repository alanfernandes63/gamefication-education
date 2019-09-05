package com.api.gamification.education.api.gamification.education.dto;

import com.api.gamification.education.api.gamification.education.model.Teacher;
import com.api.gamification.education.api.gamification.education.model.UserType;



public class ResponseTeacherDTO {
	
	private long id;
	private String name;
	private UserType userType;
	
	
	public ResponseTeacherDTO() {
		super();
	}
	public ResponseTeacherDTO(long id, String name, UserType userType) {
		super();
		this.id = id;
		this.name = name;
		this.userType = userType;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public static ResponseTeacherDTO transformToResponseTeacherDTO(Teacher teacher) {
		
		return new ResponseTeacherDTO(teacher.getId(),teacher.getName(),teacher.getUserType());
	}
	

}
