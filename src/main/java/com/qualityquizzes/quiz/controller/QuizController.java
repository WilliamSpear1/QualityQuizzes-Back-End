package com.qualityquizzes.quiz.controller;

import com.qualityquizzes.quiz.daoimpl.QuizDAOImpl;
import com.qualityquizzes.quiz.daoimpl.QuizQuestionDAOImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class QuizController {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();

    private final QuizQuestionDAOImpl quizQuestionDAO;

    private final QuizDAOImpl quizDAO;

    public QuizController (final QuizQuestionDAOImpl quizQuestionDAO, final QuizDAOImpl quizDAO) {
        this.quizQuestionDAO = quizQuestionDAO;
        this.quizDAO         = quizDAO;
    }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // TODO: Implement Controller methods and figure out
    //  what how to create quizzes and quiz questions.
}
