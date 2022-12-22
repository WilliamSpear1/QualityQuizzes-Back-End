package com.QualityQuizzes.Quiz.Controller;

import com.QualityQuizzes.Quiz.Model.ApplicationUser;
import com.QualityQuizzes.Quiz.Model.Student;
import com.QualityQuizzes.Quiz.dao.StudentDAO;
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

import javax.swing.text.html.Option;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class StudentController {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private final StudentDAO studentDAO;
    
    public StudentController(final StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        try{
            final Student _student = studentDAO.addUser(
              new Student(
                student.getFirstName(),
                student.getLastName(),
                student.getUserName(),
                student.getEmail()
             )
            );
           return new ResponseEntity<>(_student, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
//        Optional<Student> studentData = (studentData) studentDAO.getById(id);
//
//        if(studentData.isPresent()) {
//            Student _student;
//
//            _student = studentData.get();
//
//            _student.setFirstName (student.getFirstName());
//            _student.setLastName  (student.getLastName());
//            _student.setUserName  (student.getUserName());
//            _student.setEmailName (student.getEmail());
//
//            return new ResponseEntity<>(studentDAO.addUser(_student), HttpStatus.OK);
//        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/students/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("id") long id) {
        try {
            studentDAO.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}