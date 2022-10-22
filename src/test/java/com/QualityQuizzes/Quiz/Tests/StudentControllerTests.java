package com.QualityQuizzes.Quiz.Tests;

import com.QualityQuizzes.Quiz.Controller.StudentController;
import com.QualityQuizzes.Quiz.Model.Student;
import com.QualityQuizzes.Quiz.Repository.StudentRepository;
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

@WebMvcTest(StudentController.class)
public class StudentControllerTests {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @MockBean
    private StudentRepository studentRepository;
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    void should_create_student() throws Exception {
        final Student student = new Student(
            "Will",
            "Spearman",
            "Spear1",
            "Spear1@gmail.com"
        );
        
        mockMvc.perform(post("/api/students")
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(student)))
          .andExpect(status().isCreated())
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
       
        when(studentRepository.findById(Id)).thenReturn(Optional.of(student));
        
        when(studentRepository.save(ArgumentMatchers.any(Student.class))).thenReturn(studentUpdated);
        
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
    @Test
    void should_delete_student() throws Exception {
        final long Id = 1L;
        
        Student student = new Student(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com",
          Id
        );
        
        doNothing().when(studentRepository).deleteById(Id);
        
        mockMvc.perform(delete("/api/students/{id}", Id)
          .contentType(MediaType.APPLICATION_JSON)
          .content(objectMapper.writeValueAsString(student)))
          .andExpect(status().isOk())
          .andDo(print());
    }
}