package com.QualityQuizzes.Quiz.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table  (name = "student")
public class Student extends ApplicationUser {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    @Column
    private final static boolean isTeacher = false;
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Student(){}
    public Student(
      String studentFirstName,
      String studentLastName,
      String studentUserName,
      String studentEmail
    ) {
        super(
          studentFirstName,
          studentLastName,
          studentUserName,
          studentEmail
        );
    }
    public Student(
      String firstName,
      String lastName,
      String userName,
      String email,
      Long   id
    ) {
        super(
          firstName,
          lastName,
          userName,
          email,
          id
        );
    }
    
    public boolean getStatus() {return isTeacher;}
}