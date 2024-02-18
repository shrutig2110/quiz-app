package com.practice.quizapp.Controller;

import com.practice.quizapp.Service.QuestionService;
import com.practice.quizapp.model.response.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions()
    {
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
    {
         return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question)
    {
     return questionService.addQuestion(question);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateById(@PathVariable Integer id, @RequestBody Question question)
    {
        return questionService.updateById(id, question);
    }

    @DeleteMapping("/remove/{category}")
    public ResponseEntity<String> deleteQuestionByCategory(@PathVariable String category)
    {
        return questionService.deleteQuestionByCategory(category);
    }
}
