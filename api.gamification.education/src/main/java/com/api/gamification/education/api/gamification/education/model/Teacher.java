package com.api.gamification.education.api.gamification.education.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="tb_teacher")
@PrimaryKeyJoinColumn(name="id_user")
public class Teacher extends User{
	@OneToMany(mappedBy="teacher")
	private List<Question> questions;

	public Teacher() {
		super();
	}

	public Teacher(List<Question> questions) {
		super();
		this.questions = questions;
	}





	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
}
