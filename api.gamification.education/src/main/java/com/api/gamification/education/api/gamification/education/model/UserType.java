package com.api.gamification.education.api.gamification.education.model;

public enum UserType {
	
	ALUNO("ALUNO"),
	ADMIN("ADMIN"),
	TEACHER("TEACHER");
	
	private String userType;
	
	UserType(String type){
		this.userType = type;
	}
	
	public String getUserType() {
		return userType;
	}
	

}
