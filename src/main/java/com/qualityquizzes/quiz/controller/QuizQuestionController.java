package com.qualityquizzes.quiz.controller;

import com.qualityquizzes.quiz.daoimpl.QuizQuestionDAOImpl;
import com.qualityquizzes.quiz.model.QuizQuestion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class QuizQuestionController {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    private final QuizQuestionDAOImpl quizQuestionDAO;
    
    // Constructor  ///////////////////////////////////////////////////////////////////////////////////////////////////
    public QuizQuestionController (final QuizQuestionDAOImpl quizQuestionDAO) { this.quizQuestionDAO = quizQuestionDAO; }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/quizquestions/{id}")
    public ResponseEntity<List<QuizQuestion>> QuizQuestion(@PathVariable long id) {
        try{
            List<QuizQuestion> quizQuestions = quizQuestionDAO.getQuestionsByQuizId(id);
            
            logger.info("Acquiring all questions with the quiz id of: " + id);
            return new ResponseEntity<>(quizQuestions, HttpStatus.CREATED);
        }catch (Exception e) {
        
            logger.error("Exception was thrown here is the error message: " + e.getMessage());
        
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping("/quizquestions")
    public ResponseEntity<QuizQuestion> createQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
        try{
            quizQuestionDAO.addQuizQuestion(quizQuestion);
            logger.info("Created Quiz with the following id" + quizQuestion.getId());
            
            return new ResponseEntity<>(quizQuestion, HttpStatus.CREATED);
        }catch (Exception e) {
            
            logger.error("Exception was thrown here is the error message: " + e.getMessage());
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/quizquestions/{id}")
    public ResponseEntity<QuizQuestion> updateQuizQuestion(@PathVariable("id") long id, @RequestBody QuizQuestion quizQuestion) {
        try{
            quizQuestionDAO.updateQuizQuestion(quizQuestion, id);
            logger.info("Updated QuizQuestion with the following id: " + quizQuestion.getId());
            return new ResponseEntity<>(quizQuestion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/quizquestions/{id}")
    public ResponseEntity<HttpStatus> deleteQuizQuestion(@PathVariable("id") long id) {
        try {
            quizQuestionDAO.deleteQuizQuestions(id);
            
            logger.info("Deleted QuizQuestions with the following id: " + id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Exception is thrown: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}