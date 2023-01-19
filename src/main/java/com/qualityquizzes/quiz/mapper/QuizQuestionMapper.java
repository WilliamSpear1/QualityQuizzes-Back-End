package com.qualityquizzes.quiz.mapper;

import com.qualityquizzes.quiz.model.QuizQuestion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class QuizQuestionMapper implements RowMapper<QuizQuestion> {
    // Method ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public QuizQuestion mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuizQuestion quizQuestion = new QuizQuestion();
    
        quizQuestion.setQuizId          (rs.getLong("QUIZID"));
        quizQuestion.setId              (rs.getLong("QUIZQUESTIONSID"));
        quizQuestion.setQuestion        (rs.getString("QUESTION"));
        quizQuestion.setCorrectAnswer   (rs.getString("CORRECTANSWER"));
        quizQuestion.setIncorrectAnswer (rs.getString("INCORRECTANSWER"));
        
        return quizQuestion;
    }
}