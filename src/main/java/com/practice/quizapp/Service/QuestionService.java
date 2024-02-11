package com.practice.quizapp.Service;

import com.practice.quizapp.Repository.QuestionDAO;
import com.practice.quizapp.model.response.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDAO questionDAO;
    public List<Question> getAllQuestions() {

        return questionDAO.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDAO.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDAO.save(question);
        return "Success";
    }

    public String deleteQuestionById(String category) {
        questionDAO.deleteByCategory(category);
        return "Delete Success";
    }
}
