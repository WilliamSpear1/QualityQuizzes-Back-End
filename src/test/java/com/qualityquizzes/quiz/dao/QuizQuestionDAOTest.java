package com.qualityquizzes.quiz.dao;

import com.qualityquizzes.quiz.daoimpl.QuizDAOImpl;
import com.qualityquizzes.quiz.daoimpl.QuizQuestionDAOImpl;
import com.qualityquizzes.quiz.model.QuizQuestion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJdbcTest
class QuizQuestionDAOTest {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    private final JdbcTemplate jdbcTemplate;
    
    private final QuizDAOImpl quizDAO;
    
    private final QuizQuestionDAOImpl quizQuestionDAO;
    
    // Constructors /////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    public QuizQuestionDAOTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate     = jdbcTemplate;
        this.quizQuestionDAO  = new QuizQuestionDAOImpl(jdbcTemplate);
        this.quizDAO          = new QuizDAOImpl(jdbcTemplate);
    }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void FIND_QUESTIONS_BY_QUIZID() {
        List<QuizQuestion> questions = quizQuestionDAO.getQuestionsByQuizId(5L);
    
        assertNotNull(questions);
        assertEquals(questions.size(),2);
    
        assertEquals(questions.get(0).getId(),              1L);
        assertEquals(questions.get(0).getQuestion(),        "Is John Milton Alive?");
        assertEquals(questions.get(0).getCorrectAnswer(),   "Yes");
        assertEquals(questions.get(0).getIncorrectAnswer(), "No");
        
        assertEquals(questions.get(1).getId(),              9L);
        assertEquals(questions.get(1).getQuestion(),        "Did John Milton write Paradise Lost?");
        assertEquals(questions.get(1).getCorrectAnswer(),   "Yes");
        assertEquals(questions.get(1).getIncorrectAnswer(), "No");
    }
    
    @Test
    public void CREATE_QUIZ_QUESTION() {
        final QuizQuestion quizQuestion = new QuizQuestion(
            "Is Pluto a planet?",
            "No",
            "Yes",
            11L,
            5L
        );
        
        quizQuestionDAO.addQuizQuestion(quizQuestion);
    
        List<QuizQuestion> questions = quizQuestionDAO.getQuestionsByQuizId(5L);
    
        assertNotNull(questions);
        assertEquals(questions.size(),3);
    
        assertEquals(questions.get(2).getId(),              11L);
        assertEquals(questions.get(2).getQuizId(),          5L);
        assertEquals(questions.get(2).getQuestion(),        "Is Pluto a planet?");
        assertEquals(questions.get(2).getCorrectAnswer(),   "No");
        assertEquals(questions.get(2).getIncorrectAnswer(), "Yes");
    }
    
    @Test
    public void FIND_QUIZ_QUESTION() {
       final QuizQuestion quizQuestion = quizQuestionDAO.getQuestionById(9L);
    
        assertEquals(quizQuestion.getQuizId(),          5L);
        assertEquals(quizQuestion.getQuestion(),        "Did John Milton write Paradise Lost?");
        assertEquals(quizQuestion.getCorrectAnswer(),   "Yes");
        assertEquals(quizQuestion.getIncorrectAnswer(), "No");
    }
    
    @Test
    public void UPDATE_QUIZ_QUESTIONS() {
        final QuizQuestion quizQuestion = quizQuestionDAO.getQuestionById(9L);
        
        assertEquals(quizQuestion.getQuizId(),          5L);
        assertEquals(quizQuestion.getQuestion(),        "Did John Milton write Paradise Lost?");
        assertEquals(quizQuestion.getCorrectAnswer(),   "Yes");
        assertEquals(quizQuestion.getIncorrectAnswer(), "No");
    
        final QuizQuestion updateQuizQuestion = new QuizQuestion(
            "Is Pluto a planet?",
            "No",
            "Yes"
        );
        
        quizQuestionDAO.updateQuizQuestion(updateQuizQuestion,quizQuestion.getId());
        
        final QuizQuestion newQuizQuestion = quizQuestionDAO.getQuestionById(9L);
        
        assertEquals(newQuizQuestion.getId(),              9L);
        assertEquals(newQuizQuestion.getQuizId(),          5L);
        assertEquals(newQuizQuestion.getQuestion(),        "Is Pluto a planet?");
        assertEquals(newQuizQuestion.getCorrectAnswer(),   "No");
        assertEquals(newQuizQuestion.getIncorrectAnswer(), "Yes");
    }
    
    @Test
    public void DELETE_QUIZ_QUESTIONS() {
        quizQuestionDAO.deleteQuizQuestions(5L);
        
        try {
            quizQuestionDAO.getQuestionsByQuizId(5L);
        }catch (Exception e) {
            logger.error("Exception has been thrown: " + e.getMessage());
            assertEquals("Incorrect result size: expected 1, actual 0", e.getMessage());
        }
    }
}
