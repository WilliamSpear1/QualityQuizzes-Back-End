package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.mapper.StudentMapper;
import com.QualityQuizzes.Quiz.model.ApplicationUser;
import com.QualityQuizzes.Quiz.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDAO implements UserDAO<Student> {
    
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final JdbcTemplate jdbcTemplate;
    
    // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
    public StudentDAO (final JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Student> getAllUsers () {
        String sql = "SELECT id, email, user_name, first_name, last_name FROM STUDENTS";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        return students;
    }
    
    @Override
    public ApplicationUser getById (long Id) {
        String sql = "SELECT id, email, user_name, first_name, last_name FROM STUDENTS WHERE id = ?";
        return (Student) jdbcTemplate.queryForObject(sql, new StudentMapper(), Id);
    }
    
    @Override
    public Student addUser (final Student student) {
        String sql = "INSERT INTO STUDENTS (id, email, user_name, first_name, last_name) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
          sql,
          student.getId(),
          student.getEmail(),
          student.getUserName(),
          student.getFirstName(),
          student.getLastName()
        );
        return student;
    }
    
    @Override
    public void updateUser (final Student student) {
        String sql = "UPDATE STUDENTS set email = ?, user_name = ?, first_name = ?, last_name = ? where id = ?";
        jdbcTemplate.update(
          sql,
          student.getEmail(),
          student.getUserName(),
          student.getFirstName(),
          student.getLastName()
        );
    }
    
    @Override
    public void deleteUser (long Id) {
        String sql = "DELETE FROM STUDENTS WHERE ID = ?";
        jdbcTemplate.update(sql, Id);
    }
}
