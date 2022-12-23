package com.QualityQuizzes.Quiz.model;

public class Student extends ApplicationUser {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static boolean isTeacher = false;
    
    // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
    public Student () {
        super();
    }
    public Student (
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
    public Student (
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
    
    // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
    public boolean getStatus () {return isTeacher;}
}