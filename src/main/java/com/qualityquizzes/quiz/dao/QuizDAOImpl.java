package com.qualityquizzes.quiz.dao;

import com.qualityquizzes.quiz.mapper.QuizMapper;
import com.qualityquizzes.quiz.model.Quiz;
import org.springframework.jdbc.core.JdbcTemplate;

public class QuizDAOImpl implements QuizDAO{
   
    private final JdbcTemplate jdbcTemplate;
    
    public QuizDAOImpl (final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public Quiz getQuizById (long id) {
        String sql =
            "SELECT QUIZID,                " +
            "QUIZNAME, QUIZSIZE            " +
            "FROM QUIZZES WHERE QUIZID = ? ";
    
        return jdbcTemplate.queryForObject(sql, new QuizMapper(),id);
    }
    
    @Override
    public Quiz addQuiz(final Quiz quiz) {
        String sql =
            "INSERT INTO QUIZZES          " +
            " (QUIZID, QUIZNAME, QUIZSIZE)" +
            " values (?, ?, ?)            ";
        
        jdbcTemplate.update( sql, quiz.getId(), quiz.getQuizName(), quiz.getQuizSize());
        return quiz;
    }
    
    @Override
    public void updateQuiz(final Quiz quiz) {
        String sql =
            "UPDATE QUIZZES SET                     " +
            "QUIZID = ?, QUIZNAME = ?, QUIZNAME = ? " +
            "WHERE QUIZID = ?                       ";
        
        jdbcTemplate.update(sql, quiz.getId(), quiz.getQuizName(), quiz.getQuizSize());
    }
    
    @Override
    public void deleteQuiz(long Id) {
        String sql =
            "DELETE FROM QUIZZES " +
            "WHERE QUIZID = ?    ";
        
        jdbcTemplate.update(sql,Id);
    }
}