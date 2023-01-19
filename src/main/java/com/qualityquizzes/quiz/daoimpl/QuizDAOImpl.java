package com.qualityquizzes.quiz.daoimpl;

import com.qualityquizzes.quiz.dao.QuizDAO;
import com.qualityquizzes.quiz.mapper.QuizMapper;
import com.qualityquizzes.quiz.model.Quiz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class QuizDAOImpl implements QuizDAO {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    // Members /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final JdbcTemplate jdbcTemplate;
    
    // Constructor  ///////////////////////////////////////////////////////////////////////////////////////////////////
    public QuizDAOImpl (final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public Quiz getQuizById (long id) {
        String sql =
            "SELECT QUIZID,                " +
            "QUIZNAME, QUIZSIZE            " +
            "FROM QUIZZES WHERE QUIZID = ? ";
        
        try {
            return jdbcTemplate.queryForObject(sql, new QuizMapper(), id);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Could not get Quiz object with ID: " + id);
            logger.error(exception);
            return null;
        }
    }
    
    @Override
    public void addQuiz(final Quiz quiz) {
        String sql =
            "INSERT INTO QUIZZES          " +
            " (QUIZID, QUIZNAME, QUIZSIZE)" +
            " values (?, ?, ?)            ";
       
        try {
            jdbcTemplate.update( sql,
                quiz.getId(),
                quiz.getQuizName(),
                quiz.getQuizSize());
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in QuizDAO addUser method " +
                "Here is the exception:                            " +
                exception);
        }
    }
    
    @Override
    public void updateQuiz(final Quiz quiz, final long id) {
        String sql =
            "UPDATE QUIZZES SET                     " +
            "QUIZNAME = ?, QUIZSIZE = ? " +
            "WHERE QUIZID = ?                       ";
        
        try{
            jdbcTemplate.update(
                sql,
                quiz.getQuizName(),
                quiz.getQuizSize(),
                id);
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in QUIZDAO updateUser method " +
                "Here is the exception:                               " +
                exception);
        }
    }
    
    @Override
    public void deleteQuiz(long Id) {
        String sql =
            "DELETE FROM QUIZZES " +
            "WHERE QUIZID = ?    ";
    
        try {
            jdbcTemplate.update(sql, Id);
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in QUIZDAO deleteUser method " +
                "Here is the exception:                               " +
                exception);
        }
    }
}