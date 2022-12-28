package com.QualityQuizzes.Quiz;

import com.QualityQuizzes.Quiz.dao.TeacherDAO;
import com.QualityQuizzes.Quiz.model.Teacher;
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
public class TeacherDAOTest {
    
    private static final Logger logger = LogManager.getLogger();
    
    private final JdbcTemplate jdbcTemplate;
    private final TeacherDAO teacherDAO;
    
    @Autowired
    public TeacherDAOTest (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.teacherDAO   = new TeacherDAO(jdbcTemplate);
    }
    
    @Test
    public void GET_ALL_TEACHERS(){
        List<Teacher> teacherList = teacherDAO.getAllUsers();
        
        final Teacher teacher = teacherDAO.getById(2L);
        
        assertFalse(teacherList.isEmpty());
        
        assertEquals(teacherList.size(), 4);
        
        assertThat(teacherList.contains(teacher));
    }
    
    @Test
    public void CREATE_TEACHER_THEN_FIND_CREATED_TEACHER(){
        final Teacher teacher = new Teacher(
          "William",
          "Spearman",
          "spear1",
          "spear1@email.com",
          1L);
        
        logger.info("Here Creating tests.");
        teacherDAO.addUser(teacher);
        
        final Teacher newTeacher = teacherDAO.getById(1L);
        
        assertThat(newTeacher).hasFieldOrPropertyWithValue("firstName", "William");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("lastName",  "Spearman");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("userName",  "spear1");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("email",     "spear1@email.com");
    }
    
    @Test
    public void QUERY_FOR_TEACHER_ALREADY_CREATED_IN_DB(){
        final Teacher newTeacher = teacherDAO.getById(2L);
        
        assertThat(newTeacher).hasFieldOrPropertyWithValue("firstName", "Bret");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("lastName",  "Steadman");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("userName",  "steadman1");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("email",     "steadman1@email.com");
    }
    
    @Test
    public void UPDATE_TEACHER() {
        final Teacher foundTeacher = teacherDAO.getById(2L);
        
        assertThat(foundTeacher).hasFieldOrPropertyWithValue("firstName", "Bret");
        assertThat(foundTeacher).hasFieldOrPropertyWithValue("lastName",  "Steadman");
        assertThat(foundTeacher).hasFieldOrPropertyWithValue("userName",  "steadman1");
        assertThat(foundTeacher).hasFieldOrPropertyWithValue("email",     "steadman1@email.com");
        
        final Teacher updateTeacher = new Teacher(
          "Damon",
          "Atkins",
          "atkins1",
          "atkins1@email.com"
        );
        
        teacherDAO.updateUser(updateTeacher, 2L);
        
        final Teacher newTeacher = teacherDAO.getById(2L);
        
        assertThat(newTeacher).hasFieldOrPropertyWithValue("firstName", "Damon");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("lastName",  "Atkins");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("userName",  "atkins1");
        assertThat(newTeacher).hasFieldOrPropertyWithValue("email",     "atkins1@email.com");
    }
    
    @Test
    public void DELETE_TEACHER() {
        final Teacher foundTeacher = teacherDAO.getById(2L);
        
        teacherDAO.deleteUser(2L);
        
        try {
            Teacher searchTeacher = teacherDAO.getById(2L);
        } catch (Exception e) {
            logger.error("Exception has been thrown: " + e.getMessage());
            assertEquals("Incorrect result size: expected 1, actual 0", e.getMessage());
        }
    }
}
