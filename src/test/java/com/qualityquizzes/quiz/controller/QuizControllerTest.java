package com.qualityquizzes.quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qualityquizzes.quiz.daoimpl.QuizDAOImpl;
import com.qualityquizzes.quiz.model.Quiz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuizController.class)
public class QuizControllerTest {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private QuizDAOImpl quizDAO;
    
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void SHOULD_CREATE_QUIZ () throws Exception {
        final Quiz quiz = new Quiz(
            2L,
            "Math Quiz",
            10
        );
        
        mockMvc.perform(post("/api/quizzes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(quiz)))
            .andExpect(status().isCreated())
            .andDo(print());
    }
    
    @Test
    public  void SHOULD_DELETE_QUIZ () throws Exception{
        final Quiz quiz = new Quiz(
            1L,
            "Math Quiz",
            10
        );
        
        doNothing().when(quizDAO).deleteQuiz(1L);
        
        mockMvc.perform(delete("/api/quizzes/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(quiz)))
            .andExpect(status().isOk())
            .andDo(print());
    }
    
    @Test
    void SHOULD_UPDATE_QUIZ() throws Exception {
        final Quiz quiz = new Quiz(
            1L,
            "Math Quiz",
            10
        );
        
        Quiz quizUpdated = new Quiz(
            "History Quiz",
            11
        );
        
        when(quizDAO.getQuizById(quiz.getId())).thenReturn(quiz);
        
        mockMvc.perform(put("/api/quizzes/{id}", quiz.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(quizUpdated)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.quizName").value(quizUpdated.getQuizName()))
            .andExpect(jsonPath("$.quizSize").value(quizUpdated.getQuizSize()))
            .andDo(print());
    }
}
