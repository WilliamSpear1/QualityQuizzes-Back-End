package com.QualityQuizzes.Quiz.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table  (name = "student")
public class Student extends ApplicationUser {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static boolean isTeacher = false;
    
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_generator")
    private long   id;
    
    @Column(
      name             = "student_user_name",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String studentUserName;
    
    @Column(
      name             = "student_first_name",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String studentFirstName;
    
    @Column(
      name             = "student_last_name",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String studentLastName;
    
    @Column(
      name             = "student_email",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String studentEmail;
    
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
      String studentFirstName,
      String studentLastName,
      String studentUserName,
      String studentEmail,
      Long   id
    ) {
        super(
          studentFirstName,
          studentLastName,
          studentUserName,
          studentEmail,
          id
        );
    }
    
    public boolean getStatus() {return isTeacher;}
}