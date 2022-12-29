package com.QualityQuizzes.Quiz.controller;

import com.QualityQuizzes.Quiz.dao.TeacherDAO;
import com.QualityQuizzes.Quiz.model.Teacher;
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

@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private TeacherDAO teacherDAO;
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void CREATE_TEACHER () throws Exception {
        final Teacher teacher = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com",
          1L
        );
        
        mockMvc.perform(post("/api/teachers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(teacher)))
          .andExpect(status().isCreated())
          .andDo(print());
    }
    
    @Test
    public void DELETE_TEACHER () throws Exception{
        final Teacher teacher = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com",
          1L
        );
        
        doNothing().when(teacherDAO).deleteUser(1L);
        
        mockMvc.perform(delete("/api/teachers/{id}", 1L)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(teacher)))
          .andExpect(status().isOk())
          .andDo(print());
    }
    
    @Test
    void UPDATE_TEACHER () throws Exception {
        long Id = 1L;
        
        Teacher teacher = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        
        Teacher teacherUpdated = new Teacher(
          "Update",
          "Update",
          "SpearUpdate1",
          "SpearUpdate1@gmail.com"
        );
        
        when(teacherDAO.getById(Id)).thenReturn(teacher);
        
        mockMvc.perform(put("/api/teachers/{id}", Id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(teacherUpdated)))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.email").value(teacherUpdated.getEmail()))
          .andExpect(jsonPath("$.firstName").value(teacherUpdated.getFirstName()))
          .andExpect(jsonPath("$.lastName").value(teacherUpdated.getLastName()))
          .andExpect(jsonPath("$.userName").value(teacherUpdated.getUserName()))
          .andDo(print());
    }
}