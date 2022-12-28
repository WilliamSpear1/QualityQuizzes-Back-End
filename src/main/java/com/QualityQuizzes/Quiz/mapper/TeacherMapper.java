package com.QualityQuizzes.Quiz.mapper;

import com.QualityQuizzes.Quiz.model.Teacher;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherMapper implements RowMapper<Teacher> {
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
        Teacher teacher = new Teacher();
        
        teacher.setFirstName (rs.getString("firstName"));
        teacher.setLastName  (rs.getString("lastName"));
        teacher.setUserName  (rs.getString("userName"));
        teacher.setEmailName (rs.getString("email"));
        teacher.setId        (rs.getLong("id"));
        
        return teacher;
    }
}
