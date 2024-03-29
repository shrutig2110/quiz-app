package com.practice.quizapp.Service;

import com.practice.quizapp.Repository.QuestionDAO;
import com.practice.quizapp.model.response.Question;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    Optional<Question> question1;
    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(questionDAO.findAllByOrderByIdAsc(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try
        {
        return new ResponseEntity<>(questionDAO.findByCategory(category),HttpStatus.OK);
    }
        catch (Exception e)
    {
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try{
            questionDAO.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }

    }


    @Transactional
    public ResponseEntity<String> deleteQuestionByCategory(String category) {

        try {
            long deletedCount = questionDAO.deleteByCategory(category);
            if (deletedCount == 0)
            {
                throw new EntityNotFoundException("No Questions found");
            }
            return new ResponseEntity<>("Delete Success", HttpStatus.OK);
        }
        catch (EntityNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("No such data found", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> updateById(Integer id, Question question)
    {
        try{
            System.out.println("Input question" + question);
            question1 = questionDAO.findById(id);
           if(questionDAO.existsById(id))
           {
               Question existingQuestion = question1.get();
               existingQuestion.setQuestionTitle(question.getQuestionTitle());
               existingQuestion.setCategory(question.getCategory());
               existingQuestion.setDifficultlevel(question.getDifficultlevel());
               existingQuestion.setOption1(question.getOption1());
               existingQuestion.setOption2(question.getOption2());
               existingQuestion.setOption3(question.getOption3());
               existingQuestion.setOption4(question.getOption4());
               existingQuestion.setRightAnswer(question.getRightAnswer());
               questionDAO.save(existingQuestion);
               return new ResponseEntity<>("Updated data successfully", HttpStatus.ACCEPTED);
           }
           else {
               throw new EntityNotFoundException("No question for given ID exists");
           }
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
