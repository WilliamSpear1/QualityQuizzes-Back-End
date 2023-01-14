package com.qualityquizzes.quiz.mapper;

import com.qualityquizzes.quiz.model.QuizQuestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class QuizQuestionMapper implements RowMapper<QuizQuestion> {
    
    @Override
    public QuizQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuizQuestion quizQuestion = new QuizQuestion();
        
        quizQuestion.setQuestion        (rs.getString("question"));
        quizQuestion.setIncorrectAnswer (rs.getString("incorrectAnswer"));
        quizQuestion.setCorrectAnswer   (rs.getString("correctAnswer"));
        quizQuestion.setId              (rs.getLong("id"));
        
        return quizQuestion;
    }
}