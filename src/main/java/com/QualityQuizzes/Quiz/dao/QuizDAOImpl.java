package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.model.Quiz;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuizDAOImpl implements QuizDAO{
   
    private final JdbcTemplate jdbcTemplate;
    
    public QuizDAOImpl (final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
//    TODO: Finish implementing method create query for adding quiz questions.
//     Figure how to query the QuizQuestions table and grabbing all the
//     questions that are related to the Quiz and it's quizId which quizId
//     is the foreign key to most likely query on.
    @Override
    public List<Quiz> getAllQuizQuestions() {
        return null;
    }
    
//    TODO: Finish implementing method create query for creating new quizzes.
    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quiz;
    }
    
//    TODO: Finish implementing method create query for updating quizzes.
    @Override
    public void updateQuiz(Quiz quiz, long Id) {
    
    }
    
//    TODO: Finish implementing method create query for deleting quizzes.
    @Override
    public void deleteQuiz(long Id) {
    
    }
}