package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.model.Quiz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJdbcTest
public class QuizDAOTest {
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
    public void CREATE_QUIZ(){
       Quiz quiz = new Quiz(1L, "History Quiz", 5);
       
       logger.info("Created Quiz object");
       quizDAO.addQuiz(quiz);
       
       final Quiz newQuiz = quizDAO.getQuizById(1L);
    
        assertThat(newQuiz).hasFieldOrPropertyWithValue("id",        1L);
        assertThat(newQuiz).hasFieldOrPropertyWithValue("quizName",  "History Quiz");
        assertThat(newQuiz).hasFieldOrPropertyWithValue("quizSize",  5);
    }
}
