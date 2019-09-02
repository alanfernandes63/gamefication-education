package com.api.gamification.education.api.gamification.education.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tb_questions")
public class Question {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotBlank(message="field question cannot be empty")
	private String question;
	@NotNull(message="object options cannot be null")
	@NotBlank(message="field optionOne cannot be empty")
	private String optionOne;
	@NotBlank(message="field optionTwo cannot be empty")
	private String optionTwo;
	@NotBlank(message="field optionThree cannot be empty")
	private String optionThree;
	@NotBlank(message="field optionFour cannot be empty")
	private String optionFour;
	private String response;
	@NotNull
	@ManyToOne
	@JoinColumn(name="id_user")
	@JsonIgnore
	private Teacher teacher;
	
	
	public Question() {
		super();
	}

	public Question(long id, @NotBlank(message = "field question cannot be empty") String question,
			@NotNull(message = "object options cannot be null") @NotBlank(message = "field optionOne cannot be empty") String optionOne,
			@NotBlank(message = "field optionTwo cannot be empty") String optionTwo,
			@NotBlank(message = "field optionThree cannot be empty") String optionThree,
			@NotBlank(message = "field optionFour cannot be empty") String optionFour, String response,
			@NotNull Teacher teacher) {
		super();
		this.id = id;
		this.question = question;
		this.optionOne = optionOne;
		this.optionTwo = optionTwo;
		this.optionThree = optionThree;
		this.optionFour = optionFour;
		this.response = response;
		this.teacher = teacher;
	}


	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getOptionOne() {
		return optionOne;
	}



	public void setOptionOne(String optionOne) {
		this.optionOne = optionOne;
	}



	public String getOptionTwo() {
		return optionTwo;
	}



	public void setOptionTwo(String optionTwo) {
		this.optionTwo = optionTwo;
	}



	public String getOptionThree() {
		return optionThree;
	}



	public void setOptionThree(String optionThree) {
		this.optionThree = optionThree;
	}



	public String getOptionFour() {
		return optionFour;
	}



	public void setOptionFour(String optionFour) {
		this.optionFour = optionFour;
	}



	public void setResponse(String response) {
		this.response = response;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}



	public String getResponse() {
		return response;
	}
	
	
	
	
	
}
