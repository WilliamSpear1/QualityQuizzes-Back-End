package com.QualityQuizzes.Quiz.Tests;

import com.QualityQuizzes.Quiz.Model.Student;
import com.QualityQuizzes.Quiz.dao.StudentDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StudentDAOTests {
    @Autowired
    StudentDAO studentDAO;
   @Test
    public void Entry_of_Valid_Database(){
        final Student student = new Student(
          "William",
          "Spearman",
           "spear1",
          "spear1@email.com",
          1L
        );
    
        studentDAO.addUser(student);
    
        assertThat(student).hasFieldOrPropertyWithValue("email", "Spear1@gmail.com");
        assertThat(student).hasFieldOrPropertyWithValue("firstName", "Will");
        assertThat(student).hasFieldOrPropertyWithValue("lastName", "Spearman");
        assertThat(student).hasFieldOrPropertyWithValue("userName", "Spear1");
    }
        
}