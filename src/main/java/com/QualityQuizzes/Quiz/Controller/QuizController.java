package com.QualityQuizzes.Quiz.Controller;

import com.QualityQuizzes.Quiz.Model.Quiz;
import com.QualityQuizzes.Quiz.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class QuizController {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    QuizRepository quizRepository;
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/quiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        try{
            final Quiz _quiz = quizRepository.save(
              new Quiz(
                quiz.getQuizName(),
                quiz.getQuizSize(),
                quiz.getQuizQuestions()
              )
            );
            return new ResponseEntity<>(_quiz, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   // TODO: Finish implementing the methods for Quiz Controller.
}
