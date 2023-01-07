package com.QualityQuizzes.Quiz.mapper;

import com.QualityQuizzes.Quiz.model.Quiz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class QuizMapper implements RowMapper<Quiz> {
    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz quiz = new Quiz();
        
        quiz.setQuizName (rs.getString("quizName"));
        quiz.setQuizSize (rs.getInt("quizSize"));
        quiz.setId       (rs.getLong("id"));
        
        return quiz;
    }
}
