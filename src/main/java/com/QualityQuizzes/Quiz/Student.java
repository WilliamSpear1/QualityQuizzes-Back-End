package com.QualityQuizzes.Quiz;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Student extends User {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static Boolean isTeacher = false;
    
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String studentUserName;
    private String studentFirstName;
    private String studentLastName;
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    Student(
      String studentUsername,
      String studentFirstName,
      String studentLastName
    ) {
        super(
          studentUsername,
          studentFirstName,
          studentLastName
        );
    }
    public boolean getStatus() {return isTeacher;}
}
