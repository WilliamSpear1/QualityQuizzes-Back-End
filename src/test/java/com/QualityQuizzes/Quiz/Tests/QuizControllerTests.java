package com.QualityQuizzes.Quiz.Tests;

import com.QualityQuizzes.Quiz.Controller.QuizController;
import com.QualityQuizzes.Quiz.Model.Quiz;
import com.QualityQuizzes.Quiz.Model.QuizQuestion;
import com.QualityQuizzes.Quiz.Repository.QuizRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.HashSet;
import java.util.Set;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
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
   
    // TODO: Finish writing Controller Tests.
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    void should_create_quiz() throws Exception {
        Quiz quiz1 = new Quiz("Quiz1", 0);
    
        Set<QuizQuestion> quizQuestions = new HashSet<>();
    
        QuizQuestion question1 = new QuizQuestion(
          "Who is there?",
          "Will",
          "Bret"
        );
        quizQuestions.add(question1);
    
        QuizQuestion question2 = new QuizQuestion(
          "Where is Tallahassee located?",
          "Florida",
          "Georgia"
        );
        quizQuestions.add(question2);
    
        quiz1.addQuizQuestions(quizQuestions);
    
        mockMvc.perform(post("/api/quiz")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(quiz1)))
          .andExpect(status().isCreated())
          .andDo(print());
    }
}
