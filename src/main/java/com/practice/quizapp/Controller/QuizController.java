package com.practice.quizapp.Controller;

import com.practice.quizapp.Service.QuizService;
import com.practice.quizapp.model.response.Question;
import com.practice.quizapp.model.response.QuestionWrapper;
import com.practice.quizapp.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title )
    {
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("fetch/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
    {
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitResponse(@PathVariable Integer id, @RequestBody List<Response> responses)
    {
        return quizService.calculateResult(id, responses);
    }

}
