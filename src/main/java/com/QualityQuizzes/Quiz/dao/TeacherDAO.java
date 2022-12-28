package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.model.ApplicationUser;
import com.QualityQuizzes.Quiz.model.Teacher;
import com.QualityQuizzes.Quiz.mapper.TeacherMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

public class TeacherDAO implements UserDAO<Teacher> {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final JdbcTemplate jdbcTemplate;
    
    // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
    public TeacherDAO (final JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Teacher> getAllUsers () {
        String sql = "SELECT id, email, user_name, first_name, last_name FROM TEACHERS";
        List<Teacher> teachers = jdbcTemplate.query(sql, new TeacherMapper());
        return teachers;
    }
    
    @Override
    public Teacher getById (long Id) {
        String sql = "SELECT id, email, user_name, first_name, last_name FROM TEACHERS WHERE id = ?";
        return (Teacher) jdbcTemplate.queryForObject(sql, new TeacherMapper(), Id);
    }
    
    @Override
    public Teacher addUser (final Teacher teacher) {
        String sql = "INSERT INTO TEACHERS (id, email, user_name, first_name, last_name) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
          sql,
          teacher.getId(),
          teacher.getEmail(),
          teacher.getUserName(),
          teacher.getFirstName(),
          teacher.getLastName()
        );
        return teacher;
    }
    
    @Override
    public void updateUser (final Teacher teacher, long Id) {
        String sql = "UPDATE TEACHERS set email = ?, user_name = ?, first_name = ?, last_name = ? where id = ?";
        jdbcTemplate.update(
          sql,
          teacher.getEmail(),
          teacher.getUserName(),
          teacher.getFirstName(),
          teacher.getLastName()
        );
    }
    
    @Override
    public void deleteUser (long Id) {
        String sql = "DELETE FROM TEACHERS WHERE ID = ?";
        jdbcTemplate.update(sql, Id);
    }
}
