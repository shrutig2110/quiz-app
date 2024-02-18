package com.practice.quizapp.Repository;

import com.practice.quizapp.model.response.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDAO extends JpaRepository<Quiz,Integer>
{

}
