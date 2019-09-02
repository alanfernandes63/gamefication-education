package com.api.gamification.education.api.gamification.education.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.api.gamification.education.api.gamification.education.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

}
