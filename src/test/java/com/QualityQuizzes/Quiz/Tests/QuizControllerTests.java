package com.QualityQuizzes.Quiz.Tests;

import com.QualityQuizzes.Quiz.Controller.QuizController;
import com.QualityQuizzes.Quiz.Model.Quiz;
import com.QualityQuizzes.Quiz.Model.QuizQuestion;
import com.QualityQuizzes.Quiz.Model.Student;
import com.QualityQuizzes.Quiz.Repository.QuizRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(QuizController.class)
public class QuizControllerTests {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @MockBean
    private QuizRepository quizRepository;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
   
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    void should_create_quiz() throws Exception {
        Quiz quiz = new Quiz("Quiz", 0);
    
        Set<QuizQuestion> quizQuestions = new HashSet<>();
    
        final QuizQuestion question1 = new QuizQuestion(
          "Who is there?",
          "Will",
          "Bret"
        );
        quizQuestions.add(question1);
    
        final QuizQuestion question2 = new QuizQuestion(
          "Where is Tallahassee located?",
          "Florida",
          "Georgia"
        );
        quizQuestions.add(question2);
        
        quiz.addQuizQuestions(quizQuestions);
        quiz.setQuizName("Quiz2");
        
        mockMvc.perform(post("/api/quiz")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(quiz)))
          .andExpect(status().isCreated())
          .andDo(print());
    }
    @Test
    void should_update_student() throws Exception {
        long Id = 1L;
        
        Quiz quiz = new Quiz("Quiz", 0);
    
    
        final QuizQuestion question1 = new QuizQuestion(
          "Who is there?",
          "Will",
          "Bret"
        );
    
        quiz.addQuizQuestion(question1);
    
        Quiz quizUpdated = new Quiz("Quiz", 0);
    
    
        final QuizQuestion question2 = new QuizQuestion(
          "Who is where?",
          "Florida",
          "Utah"
        );
    
        quizUpdated.addQuizQuestion(question2);
        
        when(quizRepository.findById(Id)).thenReturn(Optional.of(quiz));
        
        when(quizRepository.save(ArgumentMatchers.any(Quiz.class))).thenReturn(quizUpdated);
        
        mockMvc.perform(put("/api/quiz/{id}", Id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(quizUpdated)))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.quizName").value(quizUpdated.getQuizName()))
          .andExpect(jsonPath("$.quizSize").value(quizUpdated.getQuizSize()))
          .andDo(print());
    }
    @Test
    void should_delete_quiz() throws Exception {
        final long Id = 1L;
    
        Quiz quiz = new Quiz("Quiz", 0);
    
    
        final QuizQuestion question1 = new QuizQuestion(
          "Who is there?",
          "Will",
          "Bret"
        );
        
        quiz.addQuizQuestion(question1);
        
        doNothing().when(quizRepository).deleteById(Id);
    
        mockMvc.perform(delete("/api/quiz/{id}", Id)
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(quiz)))
          .andExpect(status().isOk())
          .andDo(print());
    }
}
