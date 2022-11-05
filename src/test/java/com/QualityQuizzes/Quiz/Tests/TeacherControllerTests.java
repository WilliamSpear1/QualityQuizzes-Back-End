package com.QualityQuizzes.Quiz.Tests;

import com.QualityQuizzes.Quiz.Controller.TeacherController;
import com.QualityQuizzes.Quiz.Model.Teacher;
import com.QualityQuizzes.Quiz.Repository.TeacherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Optional;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest (TeacherController.class)
public class TeacherControllerTests {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @MockBean
    private TeacherRepository teacherRepository;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    void should_create_teacher() throws Exception {
        final Teacher teacher = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        
        mockMvc.perform(post("/api/teachers")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(teacher)))
          .andExpect(status().isCreated())
          .andDo(print());
    }
    
    @Test
    void should_update_teacher() throws Exception {
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
        
        when(teacherRepository.findById(Id)).thenReturn(Optional.of(teacher));
        
        when(teacherRepository.save(ArgumentMatchers.any(Teacher.class))).thenReturn(teacherUpdated);
        
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
    @Test
    void should_delete_teacher() throws Exception {
        final long Id = 1L;
        
        Teacher teacher = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com",
          Id
        );
        
        doNothing().when(teacherRepository).deleteById(Id);
        
        mockMvc.perform(delete("/api/teachers/{id}", Id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(teacher)))
          .andExpect(status().isOk())
          .andDo(print());
    }
}