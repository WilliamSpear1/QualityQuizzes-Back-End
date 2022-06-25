package com.QualityQuizzes.Quiz;

public class Student extends User {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private final static boolean isTeacher = false;

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
}
