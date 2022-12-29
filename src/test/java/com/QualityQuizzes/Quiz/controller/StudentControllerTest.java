package com.QualityQuizzes.Quiz.controller;

import com.QualityQuizzes.Quiz.controller.StudentController;
import com.QualityQuizzes.Quiz.dao.StudentDAO;
import com.QualityQuizzes.Quiz.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
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


@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    private static final Logger logger = LogManager.getLogger();
    
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private StudentDAO studentDAO;
    
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void CREATE_STUDENT () throws Exception {
        final Student student = new Student(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com",
          1L
        );
        
        mockMvc.perform(post("/api/students")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(student)))
          .andExpect(status().isCreated())
          .andDo(print());
    }
    
    @Test
    public  void DELETE_STUDENT () throws Exception{
        final Student student = new Student(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com",
          1L
        );
        
        doNothing().when(studentDAO).deleteUser(1L);
        
        mockMvc.perform(delete("/api/students/{id}", 1L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(student)))
          .andExpect(status().isOk())
          .andDo(print());
    }
    
    @Test
    void should_update_student() throws Exception {
        long Id = 1L;
        
        Student student = new Student(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        
        Student studentUpdated = new Student(
          "Update",
          "Update",
          "SpearUpdate1",
          "SpearUpdate1@gmail.com"
        );
        
        when(studentDAO.getById(Id)).thenReturn(student);
        
        mockMvc.perform(put("/api/students/{id}", Id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(studentUpdated)))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.email").value(studentUpdated.getEmail()))
          .andExpect(jsonPath("$.firstName").value(studentUpdated.getFirstName()))
          .andExpect(jsonPath("$.lastName").value(studentUpdated.getLastName()))
          .andExpect(jsonPath("$.userName").value(studentUpdated.getUserName()))
          .andDo(print());
    }
}
