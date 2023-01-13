package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.mapper.StudentMapper;
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
        String sql =
            "SELECT STUDENTID, EMAIL, USERNAME, FIRSTNAME, LASTNAME " +
            "FROM STUDENTS                                          ";
        
        List<Student> students = jdbcTemplate.query(sql, new StudentMapper());
        return students;
    }
    
    @Override
    public Student getById (final long Id) {
        String sql =
            "SELECT FIRSTNAME, LASTNAME, USERNAME, EMAIL, STUDENTID " +
            "FROM STUDENTS                                          " +
            "WHERE STUDENTID = ?                                    ";
        
        return jdbcTemplate.queryForObject(sql, new StudentMapper(), Id);
    }
    
    @Override
    public Student addUser (final Student student) {
        String sql =
            "INSERT INTO STUDENTS                     " +
            "(FIRSTNAME, LASTNAME, USERNAME, EMAIL, STUDENTID) " +
            "values (?, ?, ?, ?, ?)                            ";
    
        jdbcTemplate.update(
            sql,
            student.getFirstName(),
            student.getLastName(),
            student.getUserName(),
            student.getEmail(),
            student.getId());
    
        return student;
    }
    
    @Override
    public void updateUser(final Student student, final long id) {
        String sql =
            "UPDATE STUDENTS SET                                   " +
            "FIRSTNAME = ?, LASTNAME = ?, USERNAME = ?, EMAIL = ?  " +
            "WHERE STUDENTID = ?                                   ";
    
        jdbcTemplate.update(
            sql,
            student.getFirstName(),
            student.getLastName(),
            student.getUserName(),
            student.getEmail(),
            id
        );
    }
    
    @Override
    public void deleteUser (final long Id) {
        String sql =
            "DELETE FROM STUDENTS " +
            "WHERE STUDENTID = ?  ";
        
        jdbcTemplate.update(sql, Id);
    }
}
