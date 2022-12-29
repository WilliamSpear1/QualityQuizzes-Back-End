package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.dao.StudentDAO;
import com.QualityQuizzes.Quiz.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJdbcTest
public class StudentDAOTest {
    
    private static final Logger logger = LogManager.getLogger();
    
    private final JdbcTemplate jdbcTemplate;
    private final StudentDAO studentDAO;
    
    @Autowired
    public StudentDAOTest (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.studentDAO   = new StudentDAO(jdbcTemplate);
    }
   
    @Test
    public void GET_ALL_STUDENTS(){
        List<Student> studentList = studentDAO.getAllUsers();
    
        final Student student = studentDAO.getById(2L);
        
        assertFalse(studentList.isEmpty());
        
        assertEquals(studentList.size(), 4);
        
        assertThat(studentList.contains(student));
    }
    
    @Test
    public void CREATE_STUDENT_THEN_FIND_CREATED_STUDENT(){
        final Student student = new Student(
          "William",
          "Spearman",
          "spear1",
          "spear1@email.com",
          1L);

        logger.info("Here Creating tests.");
        studentDAO.addUser(student);
        
        final Student newStudent = studentDAO.getById(1L);
        
        assertThat(newStudent).hasFieldOrPropertyWithValue("firstName", "William");
        assertThat(newStudent).hasFieldOrPropertyWithValue("lastName",  "Spearman");
        assertThat(newStudent).hasFieldOrPropertyWithValue("userName",  "spear1");
        assertThat(newStudent).hasFieldOrPropertyWithValue("email",     "spear1@email.com");
    }
    
    @Test
    public void QUERY_FOR_STUDENT_ALREADY_CREATED_IN_DB(){
        final Student newStudent = studentDAO.getById(2L);
    
        assertThat(newStudent).hasFieldOrPropertyWithValue("firstName", "Bret");
        assertThat(newStudent).hasFieldOrPropertyWithValue("lastName",  "Steadman");
        assertThat(newStudent).hasFieldOrPropertyWithValue("userName",  "steadman1");
        assertThat(newStudent).hasFieldOrPropertyWithValue("email",     "steadman1@email.com");
    }
   
    @Test
    public void UPDATE_STUDENT() {
        final Student foundStudent = studentDAO.getById(2L);
        
        assertThat(foundStudent).hasFieldOrPropertyWithValue("firstName", "Bret");
        assertThat(foundStudent).hasFieldOrPropertyWithValue("lastName",  "Steadman");
        assertThat(foundStudent).hasFieldOrPropertyWithValue("userName",  "steadman1");
        assertThat(foundStudent).hasFieldOrPropertyWithValue("email",     "steadman1@email.com");
        
        final Student updateStudent = new Student(
          "Damon",
          "Atkins",
          "atkins1",
          "atkins1@email.com"
        );
        
        studentDAO.updateUser(updateStudent, 2L);
    
        final Student newStudent = studentDAO.getById(2L);
    
        assertThat(newStudent).hasFieldOrPropertyWithValue("firstName", "Damon");
        assertThat(newStudent).hasFieldOrPropertyWithValue("lastName",  "Atkins");
        assertThat(newStudent).hasFieldOrPropertyWithValue("userName",  "atkins1");
        assertThat(newStudent).hasFieldOrPropertyWithValue("email",     "atkins1@email.com");
    }
   
    @Test
    public void DELETE_STUDENT() {
        final Student foundStudent = studentDAO.getById(2L);
        
        studentDAO.deleteUser(2L);
        
        try {
            Student searchStudent = studentDAO.getById(2L);
        } catch (Exception e) {
            logger.error("Exception has been thrown: " + e.getMessage());
            assertEquals("Incorrect result size: expected 1, actual 0", e.getMessage());
        }
    }
}