package com.qualityquizzes.quiz.daoimpl;

import com.qualityquizzes.quiz.dao.UserDAO;
import com.qualityquizzes.quiz.mapper.StudentMapper;
import com.qualityquizzes.quiz.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDAOImpl implements UserDAO<Student> {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    // Members /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final JdbcTemplate jdbcTemplate;
    
    
    // Constructor ///////////////////////////////////////////////////////////////////////////////////////////////////
    public StudentDAOImpl(final JdbcTemplate jdbcTemplate) { this.jdbcTemplate = jdbcTemplate; }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Student> getAllUsers () {
        String sql =
            "SELECT STUDENTID, EMAIL, USERNAME, FIRSTNAME, LASTNAME " +
            "FROM STUDENTS                                          ";
        try {
            return jdbcTemplate.query(sql, new StudentMapper());
        } catch (EmptyResultDataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Students getAllUsers method " +
                "Here is the exception:                                " +
                exception);
            return null;
        }
    }
    
    @Override
    public Student getById (final long Id) {
        String sql =
            "SELECT FIRSTNAME, LASTNAME, USERNAME, EMAIL, STUDENTID " +
            "FROM STUDENTS                                          " +
            "WHERE STUDENTID = ?                                    ";
        
        try {
            return jdbcTemplate.queryForObject(sql, new StudentMapper(), Id);
        }catch (EmptyResultDataAccessException exception) {
          logger.error("Could not get Student object with ID: " + Id);
          logger.error(exception.toString());
          return null;
        }
    }
    
    @Override
    public void addUser (final Student student) {
        String sql =
            "INSERT INTO STUDENTS                     " +
            "(FIRSTNAME, LASTNAME, USERNAME, EMAIL, STUDENTID) " +
            "values (?, ?, ?, ?, ?)                            ";
    
        try {
             jdbcTemplate.update(
                sql,
                student.getFirstName(),
                student.getLastName(),
                student.getUserName(),
                student.getEmail(),
                student.getId());
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Students addUser method " +
                "Here is the exception:                             " +
                exception);
        }
    }
    
    @Override
    public void updateUser(final Student student, final long id) {
        String sql =
            "UPDATE STUDENTS SET                                   " +
            "FIRSTNAME = ?, LASTNAME = ?, USERNAME = ?, EMAIL = ?  " +
            "WHERE STUDENTID = ?                                   ";
        
        try {
            jdbcTemplate.update(
                sql,
                student.getFirstName(),
                student.getLastName(),
                student.getUserName(),
                student.getEmail(),
                id);
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Students updateUser method " +
                "Here is the exception:                                " +
                exception);
        }
    }
    
    @Override
    public void deleteUser (final long Id) {
        String sql =
            "DELETE FROM STUDENTS " +
            "WHERE STUDENTID = ?  ";
        
        try {
            jdbcTemplate.update(sql, Id);
        } catch (DataAccessException exception) {
            logger.error(
                "DataBase Error occurred in Students deleteUser method " +
                "Here is the exception:                                " +
                exception);
        }
    }
}
