package com.api.gamification.education.api.gamification.education.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.gamification.education.api.gamification.education.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUserName(String userName);
}
