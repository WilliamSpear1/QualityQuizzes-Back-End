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
    public StudentDAO (final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Student> getAllUsers () {
        String sql = "SELECT id, email, userName, firstName, lastName FROM students";
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        return students;
    }
    
    @Override
    public Student getById (long Id) {
        String sql = "select id, email, userName, firstName, lastName FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new StudentMapper(), Id);
    }
    
    @Override
    public Student addUser (final Student student) {
        String sql = "INSERT INTO students (id, email, userName, firstName, lastName) values (?, ?, ?, ?, ?)";
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
    public void updateUser(Student student, long Id) {
        String sql = "UPDATE students set email = ?, userName = ?, firstName = ?, lastName = ? where id = ?";
        jdbcTemplate.update(
          sql,
          student.getEmail(),
          student.getUserName(),
          student.getFirstName(),
          student.getLastName(),
          Id
        );
    }
    
    @Override
    public void deleteUser (long Id) {
        String sql = "DELETE FROM students WHERE ID = ?";
        jdbcTemplate.update(sql, Id);
    }
}
