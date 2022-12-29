package com.QualityQuizzes.Quiz.controller;

import com.QualityQuizzes.Quiz.model.Student;
import com.QualityQuizzes.Quiz.dao.StudentDAO;
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

public class StudentController {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final Logger logger = LogManager.getLogger();
    
    private final StudentDAO studentDAO;
   
    public StudentController (final StudentDAO studentDAO) { this.studentDAO = studentDAO; }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try{
            studentDAO.addUser(student);
            
            logger.info("Created Student with the following id" + student.getId());
           
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }catch (Exception e) {
            
            logger.error("Exception was thrown here is the error message: " + e.getMessage());
            
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        try{
            studentDAO.updateUser(student, id);
            logger.info("Updated Student with the following id: " + student.getId());
            return new ResponseEntity<>(student, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
        try {
            studentDAO.deleteUser(id);
            
            logger.info("Deleted Student with the following id: " + id);
            
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            logger.error("Exception is thrown: " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}