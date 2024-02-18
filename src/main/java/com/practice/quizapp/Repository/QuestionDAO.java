package com.practice.quizapp.Repository;

import com.practice.quizapp.model.response.Question;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionDAO extends JpaRepository<Question, Integer> {

    List<Question> findAllByOrderByIdAsc();
    List<Question> findByCategory(String category);
    @Transactional
    int deleteByCategory(String category);

    @Query(value = "SELECT * FROM question as q WHERE q.category =:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
