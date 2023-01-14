package com.qualityquizzes.quiz.controller;

import com.qualityquizzes.quiz.daoimpl.TeacherDAOImpl;
import com.qualityquizzes.quiz.model.Teacher;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TeacherController {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    private final TeacherDAOImpl teacherDAO;
    
    public TeacherController (final TeacherDAOImpl teacherDAO) { this.teacherDAO = teacherDAO; }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/teachers")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        try{
            teacherDAO.addUser(teacher);
            logger.info("Created Teacher with the following id" + teacher.getId());
            return new ResponseEntity<>(teacher, HttpStatus.CREATED);
        }catch (Exception e) {
            logger.error("Exception was thrown here is the error message: " + e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") long id, @RequestBody Teacher teacher) {
        try{
            teacherDAO.updateUser(teacher, id);
            logger.info("Updated Teacher with the following id: " + teacher.getId());
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable("id") long id) {
        try {
            teacherDAO.deleteUser(id);
            
            logger.info("Deleted Teacher with the following id: " + id);
            
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Exception is thrown: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}