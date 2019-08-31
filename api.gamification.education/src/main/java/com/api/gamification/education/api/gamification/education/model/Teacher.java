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
	@OneToMany
	private List<Activity> activities;

	public Teacher() {
		super();
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
}
