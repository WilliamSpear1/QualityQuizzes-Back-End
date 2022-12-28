package com.QualityQuizzes.Quiz.mapper;

import com.QualityQuizzes.Quiz.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        
        student.setFirstName (rs.getString("firstName"));
        student.setLastName  (rs.getString("lastName"));
        student.setUserName  (rs.getString("userName"));
        student.setEmailName (rs.getString("email"));
        student.setId        (rs.getLong("id"));
        
        return student;
    }
}
