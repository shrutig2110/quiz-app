package com.practice.quizapp.Repository;

import com.practice.quizapp.model.response.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

}
