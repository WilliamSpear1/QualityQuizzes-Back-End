package com.qualityquizzes.quiz.daoimpl;

import com.qualityquizzes.quiz.dao.QuizQuestionDAO;
import com.qualityquizzes.quiz.mapper.QuizQuestionMapper;
import com.qualityquizzes.quiz.model.QuizQuestion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuizQuestionDAOImpl implements QuizQuestionDAO {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    // Members /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final JdbcTemplate jdbcTemplate;
    
    public QuizQuestionDAOImpl (final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<QuizQuestion> getQuestionsByQuizId(final long quizId) {
        String sql =
            "SELECT QUESTION, CORRECTANSWER, INCORRECTANSWER " +
            "FROM QUIZQUESTIONS WHERE QUIZID = ?             ";
        
        try {
            return  jdbcTemplate.query(sql, new QuizQuestionMapper(), quizId);
        }catch (EmptyResultDataAccessException exception) {
            logger.error(
                "DataBase Error occurred in QuizQuestionDAO getQuizQuestionsById method " +
                "Here is the exception:                                                " +
                 exception);
            return null;
        }
    }
    
    @Override
    public QuizQuestion getQuestionById(final long id) {
        String sql =
            "SELECT QUESTION, CORRECTANSER, INCORRECTANSWER" +
            "FROM QUIZQUESTION WHERE QUESTIONID = ?        ";
        
        try {
            return jdbcTemplate.queryForObject(sql, new QuizQuestionMapper(), id);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Could not get Quiz Question object with ID: " + id);
            logger.error(exception.toString());
            return null;
        }
    }
    
    @Override
    public QuizQuestion addQuizQuestion(final QuizQuestion quizQuestion) {
        String sql =
            "INSERT INTO QUIZQUESTIONS" +
                "(QUESTION, CORRECTANSWER, INCORRECTANSWER) " +
                "values (?,?,?) WHERE QUIZID = ?";
        
        try {
            jdbcTemplate.update(
                sql,
                quizQuestion.getQuestion(),
                quizQuestion.getCorrectAnswer(),
                quizQuestion.getIncorrectAnswer(),
                quizQuestion.getQuizId()
                );
            return quizQuestion;
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Students addUser method " +
                "Here is the exception:                             " +
                exception);
            return null;
        }
    }
    
    @Override
    public void updateQuizQuestion(final QuizQuestion quizQuestion, final long id) {
        String sql =
            "UPDATE QUIZQUESTIONS SET                             " +
            "QUESTION = ?, CORRECTANSWER = ?, INCORRECTANSWER = ? " +
            "WHERE QUESTIONID = ?                                 ";
        
        try {
            jdbcTemplate.update(
                sql,
                quizQuestion.getQuestion(),
                quizQuestion.getCorrectAnswer(),
                quizQuestion.getIncorrectAnswer(),
                quizQuestion.getId()
            );
        }catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in QuizQuestions updateQuizQuestion method " +
                "Here is the exception:                                             " +
                 exception);
        }
    }
    
    @Override
    public void deleteQuizQuestions(long id) {
        String sql = "DELTE FROM QUIZQUESTIONS" +
            "WHERE QUIZID = ?";
        
        try {
            jdbcTemplate.update(sql, id);
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in QUIZQUESTIONDAO deleteQUIZQUESTION method " +
                "Here is the exception:                                               " +
                 exception);
        }
    }
}
