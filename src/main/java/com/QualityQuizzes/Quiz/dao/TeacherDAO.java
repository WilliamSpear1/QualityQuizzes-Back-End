package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.mapper.TeacherMapper;
import com.QualityQuizzes.Quiz.model.Teacher;
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
        String sql =
            "SELECT TEACHERID, EMAIL, USERNAME, FIRSTNAME, LASTNAME " +
            "FROM TEACHERS                                          ";
        
        List<Teacher> teachers = jdbcTemplate.query(sql, new TeacherMapper());
        return teachers;
    }
    
    @Override
    public Teacher getById (final long Id) {
        String sql =
            "SELECT TEACHERID, EMAIL, USERNAME, FIRSTNAME, LASTNAME " +
            "FROM TEACHERS                                          " +
            "WHERE TEACHERID = ?                                    ";
        
        return jdbcTemplate.queryForObject(sql, new TeacherMapper(), Id);
    }
    
    @Override
    public Teacher addUser (final Teacher teacher) {
        String sql =
            "INSERT INTO TEACHERS                              " +
            "(FIRSTNAME, LASTNAME, USERNAME, EMAIL, TEACHERID) " +
            "VALUES (?, ?, ?, ?, ?)                            ";
        jdbcTemplate.update(
            sql,
            teacher.getFirstName(),
            teacher.getLastName(),
            teacher.getUserName(),
            teacher.getEmail(),
            teacher.getId()
        );
        return teacher;
    }
    
    @Override
    public void updateUser (final Teacher teacher, final long id ) {
        String sql =
            "UPDATE TEACHERS SET                                  " +
            "FIRSTNAME = ?, LASTNAME = ?, USERNAME = ?, EMAIL = ? " +
            "WHERE TEACHERID = ?                                  ";
    
        jdbcTemplate.update(
            sql,
            teacher.getFirstName(),
            teacher.getLastName(),
            teacher.getUserName(),
            teacher.getEmail(),
            id
        );
    }
    
    @Override
    public void deleteUser (long Id) {
        String sql =
            "DELETE FROM        " +
            "TEACHERS           " +
            "WHERE TEACHERID = ?";
        
        jdbcTemplate.update(sql, Id);
    }
}