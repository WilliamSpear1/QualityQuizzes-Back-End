package com.qualityquizzes.quiz.dao;

import com.qualityquizzes.quiz.daoimpl.QuizDAOImpl;
import com.qualityquizzes.quiz.model.Quiz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJdbcTest
class QuizDAOTest {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    private final JdbcTemplate jdbcTemplate;
    
    private final QuizDAOImpl quizDAO;
    
    // Constructors /////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    public QuizDAOTest (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.quizDAO  = new QuizDAOImpl(jdbcTemplate);
    }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @Test
    public void FIND__QUIZ() {
        final Quiz foundQuiz = quizDAO.getQuizById(2L);
    
        assertThat(foundQuiz).hasFieldOrPropertyWithValue("id",        2L);
        assertThat(foundQuiz).hasFieldOrPropertyWithValue("quizName",  "History Quiz");
        assertThat(foundQuiz).hasFieldOrPropertyWithValue("quizSize",  10);
    }
    
    @Test
    public void CREATE_QUIZ() {
       Quiz quiz = new Quiz(1L, "History Quiz", 5);
       
       logger.info("Created Quiz object");
       
       quizDAO.addQuiz(quiz);
       
       final Quiz newQuiz = quizDAO.getQuizById(1L);
    
        assertThat(newQuiz).hasFieldOrPropertyWithValue("id",        1L);
        assertThat(newQuiz).hasFieldOrPropertyWithValue("quizName",  "History Quiz");
        assertThat(newQuiz).hasFieldOrPropertyWithValue("quizSize",  5);
    }
    
    @Test
    public void UPDATE_QUIZ() {
        final Quiz foundQuiz = quizDAO.getQuizById(3L);
    
        assertThat(foundQuiz).hasFieldOrPropertyWithValue("id",        3L);
        assertThat(foundQuiz).hasFieldOrPropertyWithValue("quizName",  "Math Quiz");
        assertThat(foundQuiz).hasFieldOrPropertyWithValue("quizSize",  9);
        
        final Quiz updateQuiz = new Quiz(
            "Programming Quiz",
            5
        );
        
        quizDAO.updateQuiz(updateQuiz, foundQuiz.getId());
       
        final Quiz newQuiz = quizDAO.getQuizById(3L);
    
        assertThat(newQuiz).hasFieldOrPropertyWithValue("id",       3L);
        assertThat(newQuiz).hasFieldOrPropertyWithValue("quizName", "Programming Quiz");
        assertThat(newQuiz).hasFieldOrPropertyWithValue("quizSize", 5);
    }
    
    @Test
    public void DELETE_QUIZ() {
        quizDAO.deleteQuiz(2L);
    
        try {
            quizDAO.getQuizById(2L);
        } catch (Exception e) {
            logger.error("Exception has been thrown: " + e.getMessage());
            assertEquals("Incorrect result size: expected 1, actual 0", e.getMessage());
        }
    }
}
