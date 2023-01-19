package com.qualityquizzes.quiz.controller;

import com.qualityquizzes.quiz.daoimpl.QuizDAOImpl;
import com.qualityquizzes.quiz.model.Quiz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class QuizController {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();

    private final QuizDAOImpl quizDAO;
    
    // Constructor  ///////////////////////////////////////////////////////////////////////////////////////////////////
    public QuizController (final QuizDAOImpl quizDAO) { this.quizDAO = quizDAO; }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/quiz")
    public ResponseEntity<Quiz> createQuiz(@RequestBody Quiz quiz) {
        try{
            quizDAO.addQuiz(quiz);
            logger.info("Created Quiz with the following id" + quiz.getId());
        
            return new ResponseEntity<>(quiz, HttpStatus.CREATED);
        }catch (Exception e) {
        
            logger.error("Exception was thrown here is the error message: " + e.getMessage());
        
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
   @PutMapping("/quiz/{id}")
   public ResponseEntity<Quiz> updateQuiz(@PathVariable ("id") long id, @RequestBody Quiz quiz) {
       try{
           quizDAO.updateQuiz(quiz, id);
           logger.info("Updated Quiz with the following id: " + quiz.getId());
           return new ResponseEntity<>(quiz, HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
   }
    
    @DeleteMapping("/quiz/{id}")
    public ResponseEntity<HttpStatus> deleteQuiz(@PathVariable("id") long id) {
        try {
            quizDAO.deleteQuiz(id);
            
            logger.info("Deleted Quiz with the following id: " + id);
            
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Exception is thrown: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
