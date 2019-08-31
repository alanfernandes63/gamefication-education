package com.api.gamification.education.api.gamification.education.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name="id_user")
@Table(name="user_admin")
public class Admin extends User{

}
