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
    
        student.setFirstName (rs.getString("FIRSTNAME"));
        student.setLastName  (rs.getString("LASTNAME"));
        student.setUserName  (rs.getString("USERNAME"));
        student.setEmailName (rs.getString("EMAIL"));
        student.setId        (rs.getLong("STUDENTID"));
        
        return student;
    }
}
