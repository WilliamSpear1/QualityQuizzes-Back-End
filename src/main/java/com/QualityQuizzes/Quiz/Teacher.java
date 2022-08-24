package com.QualityQuizzes.Quiz;

// TODO: Make class a JPA Entity along with creation of TABLES, COLUMNS, AND MORE.
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
   public Boolean getStatus() {return isTeacher;}
}