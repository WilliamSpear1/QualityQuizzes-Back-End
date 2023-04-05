package com.qualityquizzes.quiz.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qualityquizzes.quiz.daoimpl.QuizQuestionDAOImpl;
import com.qualityquizzes.quiz.model.QuizQuestion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuizQuestionController.class)
class QuizQuestionControllerTest {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @MockBean
    private QuizQuestionDAOImpl quizQuestionDAO;
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void SHOULD_CREATE_QUIZ_QUESTIONS () throws Exception {
        final QuizQuestion quizQuestion = new QuizQuestion(
            "Capital of Florida is Tallahassee?",
            "True",
            "False",
            11L,
            1L
        );
        
        mockMvc.perform(post("/api/quizquestions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(quizQuestion)))
            .andExpect(status().isCreated())
            .andDo(print());
    }
    
    @Test
    public  void SHOULD_DELETE_QUIZ_QUESTIONS () throws Exception{
        List<QuizQuestion> questions = new ArrayList<QuizQuestion>();
    
        questions.add(
            new QuizQuestion(
                "Capital of Florida is Tallahassee?",
                "True",
                "False",
                11L,
                1L
            ));
    
        questions.add(
            new QuizQuestion(
                "Capital of Florida is not Tallahassee?",
                "False",
                "True",
                12L,
                1L
            ));
        
        doNothing().when(quizQuestionDAO).deleteQuizQuestions(1L);
        
        mockMvc.perform(delete("/api/quizquestions/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(questions)))
            .andExpect(status().isOk())
            .andDo(print());
    }
    
    @Test
    void SHOULD_UPDATE_QUIZ_QUESTION() throws Exception {
        final QuizQuestion quizQuestion = new QuizQuestion(
            "Capital of Florida is Tallahassee?",
            "True",
            "False",
            11L,
            1L
        );
        
        QuizQuestion quizUpdated = new QuizQuestion(
            "Capital of Georgia is Tallahassee?",
            "False",
            "True"
        );
        
        when(quizQuestionDAO.getQuestionById(quizQuestion.getId())).thenReturn(quizQuestion);
        
        mockMvc.perform(put("/api/quizquestions/{id}", quizQuestion.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(quizUpdated)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(quizUpdated.getId()))
            .andExpect(jsonPath("$.question").value(quizUpdated.getQuestion()))
            .andExpect(jsonPath("$.correctAnswer").value(quizUpdated.getCorrectAnswer()))
            .andExpect(jsonPath("$.incorrectAnswer").value(quizUpdated.getIncorrectAnswer()))
            .andDo(print());
    }
    
    @Test
    void SHOULD_FIND_QUIZ_QUESTIONS() throws Exception {
        List<QuizQuestion> questions = new ArrayList<QuizQuestion>();
    
        questions.add(
            new QuizQuestion(
                "Capital of Florida is Tallahassee?",
                "True",
                "False",
                11L,
                1L
            ));
    
        questions.add(
            new QuizQuestion(
                "Capital of Florida is not Tallahassee?",
                "False",
                "True",
                12L,
                1L
            ));
        
        when(quizQuestionDAO.getQuestionsByQuizId(1L)).thenReturn(questions);
        
        mockMvc.perform(get("/api/quizquestions/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(questions)))
            .andExpect(status().isCreated())
            .andDo(print());
    }
    
}