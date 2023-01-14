package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.mapper.TeacherMapper;
import com.QualityQuizzes.Quiz.model.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class TeacherDAO implements UserDAO<Teacher> {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    // Members /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final JdbcTemplate jdbcTemplate;
    
    // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
    public TeacherDAO (final JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Teacher> getAllUsers () {
        String sql =
            "SELECT TEACHERID, EMAIL, USERNAME, FIRSTNAME, LASTNAME " +
            "FROM TEACHERS                                          ";
        try {
            return jdbcTemplate.query(sql, new TeacherMapper());
        } catch (EmptyResultDataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Teachers getAllUsers method " +
                "Here is the exception:                                " +
                exception);
            return null;
        }
    }
    
    @Override
    public Teacher getById (final long Id) {
        String sql =
            "SELECT TEACHERID, EMAIL, USERNAME, FIRSTNAME, LASTNAME " +
            "FROM TEACHERS                                          " +
            "WHERE TEACHERID = ?                                    ";
       
        try {
            return jdbcTemplate.queryForObject(sql, new TeacherMapper(), Id);
        } catch (EmptyResultDataAccessException exception) {
            logger.error("Could not get Student object with ID: " + Id +
                         "Exception occurred: " + exception);
            return null;
        }
    }
    
    @Override
    public Teacher addUser (final Teacher teacher) {
        String sql =
            "INSERT INTO TEACHERS                              " +
            "(FIRSTNAME, LASTNAME, USERNAME, EMAIL, TEACHERID) " +
            "VALUES (?, ?, ?, ?, ?)                            ";
        
        try {
            jdbcTemplate.update(
                sql,
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getUserName(),
                teacher.getEmail(),
                teacher.getId()
            );
            return teacher;
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Teachers addUser method " +
                "Here is the exception:                             " +
                exception);
            return null;
        }
    }
    
    @Override
    public void updateUser (final Teacher teacher, final long id ) {
        String sql =
            "UPDATE TEACHERS SET                                  " +
            "FIRSTNAME = ?, LASTNAME = ?, USERNAME = ?, EMAIL = ? " +
            "WHERE TEACHERID = ?                                  ";
    
        try {
            jdbcTemplate.update(
                sql,
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getUserName(),
                teacher.getEmail(),
                id);
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Teachers updateUser method " +
                "Here is the exception:                                " +
                exception);
        }
    }
    
    @Override
    public void deleteUser (long Id) {
        String sql =
            "DELETE FROM        " +
            "TEACHERS           " +
            "WHERE TEACHERID = ?";
    
        try {
            jdbcTemplate.update(sql, Id);
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Teachers deleteUser method " +
                "Here is the exception:                                " +
                exception);
        }
    }
}