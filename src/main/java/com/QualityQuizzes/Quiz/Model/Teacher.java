package com.QualityQuizzes.Quiz.Model;

import com.QualityQuizzes.Quiz.Model.ApplicationUser;

public class Teacher extends ApplicationUser {
    // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
    private static final boolean isTeacher = true;

    // Members /////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String teacherEmail;
    private String teacherFirstName;
    private String teacherLastName;
    private Long   id;
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
   Teacher(
           String teacherFirstName,
           String teacherLastName,
           Long   id
   ) {
        super(
                teacherFirstName,
                teacherLastName,
                id
        );
   }
   public Boolean getStatus() {return isTeacher;}
}