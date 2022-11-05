package com.QualityQuizzes.Quiz.Controller;

import com.QualityQuizzes.Quiz.Model.Quiz;
import com.QualityQuizzes.Quiz.Repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    
    @PutMapping("/quiz/{id}")
    public ResponseEntity<Quiz> updateQuiz(@PathVariable("id") long id, @RequestBody Quiz quiz) {
        Optional<Quiz> quizData = quizRepository.findById(id);
        
        if(quizData.isPresent()) {
            Quiz _quiz;
            
            _quiz = quizData.get();
            
            _quiz.setQuizName (quiz.getQuizName());
            _quiz.addQuizQuestions(quiz.getQuizQuestions());
            
            return new ResponseEntity<>(quizRepository.save(_quiz), HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/quiz/{id}")
    public ResponseEntity<HttpStatus> deleteQuiz(@PathVariable("id") long id) {
        try {
            quizRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
