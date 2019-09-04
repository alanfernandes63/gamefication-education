package com.api.gamification.education.api.gamification.education.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_user")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class User {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_user")
	private long id;
	@NotBlank(message="field name cannot be empty")
	private String name;
	@Enumerated(EnumType.STRING)
	@NotNull(message="object userType cannot be null")
	private UserType userType;
	@NotBlank(message="field passord cannot be empty")
	private String password;
	@Column(unique=true)
	@NotBlank(message="fiel userName cannot be empty")
	private String userName;
	
	public User() {
		super();
	}

	public User(long id, String name,UserType userType,String password,String userName) {
		super();
		this.id = id;
		this.name = name;
		this.userType = userType;
		this.password = password;
		this.userName = userName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
				
}
