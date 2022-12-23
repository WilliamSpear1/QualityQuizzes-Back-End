package com.QualityQuizzes.Quiz.controller;

import com.QualityQuizzes.Quiz.model.Teacher;
import com.QualityQuizzes.Quiz.dao.TeacherDAO;
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
    private final TeacherDAO teacherDAO;
    
    public TeacherController (final TeacherDAO teacherDAO) {
       this.teacherDAO = teacherDAO;
    }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/teachers")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        try{
            final Teacher _teacher = teacherDAO.addUser(
              new Teacher(
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getUserName(),
                teacher.getEmail()
              )
            );
            return new ResponseEntity<>(_teacher, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") long id, @RequestBody Teacher teacher) {
//        Optional<Teacher> teacherData = teacherRepository.findById(id);
//
//        if(teacherData.isPresent()) {
//            Teacher _teacher;
//
//            _teacher = teacherData.get();
//
//            _teacher.setFirstName (teacher.getFirstName());
//            _teacher.setLastName  (teacher.getLastName());
//            _teacher.setUserName  (teacher.getUserName());
//            _teacher.setEmailName (teacher.getEmail());
//
//            return new ResponseEntity<>(teacherRepository.save(_teacher), HttpStatus.OK);
//        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/teachers/{id}")
    public ResponseEntity<HttpStatus> deleteTeacher(@PathVariable("id") long id) {
        try {
            teacherDAO.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}