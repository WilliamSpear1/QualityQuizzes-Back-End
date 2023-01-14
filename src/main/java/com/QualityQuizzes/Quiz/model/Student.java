package com.QualityQuizzes.Quiz.model;

public class Student extends ApplicationUser {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static boolean isTeacher = false;
    
    // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
    public Student () {
        super();
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
    
    public Student (
        String firstName,
        String lastName,
        String userName,
        String email
    ) {
        super(
            firstName,
            lastName,
            userName,
            email
        );
    }
    
    // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
    public boolean getStatus () {return isTeacher;}
}