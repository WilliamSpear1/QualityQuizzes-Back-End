package com.qualityquizzes.quiz.mapper;

import com.qualityquizzes.quiz.model.Teacher;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    // Method ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();
        
        teacher.setFirstName (rs.getString("FIRSTNAME"));
        teacher.setLastName  (rs.getString("LASTNAME"));
        teacher.setUserName  (rs.getString("USERNAME"));
        teacher.setEmailName (rs.getString("EMAIL"));
        teacher.setId        (rs.getLong("TEACHERID"));
        
        return teacher;
    }
}
