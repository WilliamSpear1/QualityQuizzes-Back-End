package com.qualityquizzes.quiz.mapper;

import com.qualityquizzes.quiz.model.Quiz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class QuizMapper implements RowMapper<Quiz> {
    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz quiz = new Quiz();
    
        quiz.setId       (rs.getLong("QUIZID"));
        quiz.setQuizName (rs.getString("QUIZNAME"));
        quiz.setQuizSize (rs.getInt("QUIZSIZE"));
        
        return quiz;
    }
}
