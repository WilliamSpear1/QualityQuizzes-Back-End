package com.QualityQuizzes.Quiz.Model;

import com.QualityQuizzes.Quiz.Model.ApplicationUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity (name = "Student")
@Table  (name = "student")
public class Student extends ApplicationUser {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static boolean isTeacher = false;
    
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Id

    @OneToOne
    @JoinColumn(name = "user_id")
    private Long   id;
    
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
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Student(){}
    Student(
      String studentFirstName,
      String studentLastName,
      Long   id
    ) {
        super(
          studentFirstName,
          studentLastName,
          id
        );
    }
    public boolean getStatus() {return isTeacher;}
}