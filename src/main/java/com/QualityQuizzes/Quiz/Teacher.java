package com.QualityQuizzes.Quiz;

public class Teacher extends User {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final boolean isTeacher = true;

    // Members /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String teacherUserName;
    private String teacherFirstName;
    private String teacherLastName;

    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
   Teacher(
           String teacherUserName,
           String teacherFirstName,
           String teacherLastName
   ) {
        super(
                teacherUserName,
                teacherFirstName,
                teacherLastName
        );
   }
}