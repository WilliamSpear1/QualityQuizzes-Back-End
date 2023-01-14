package com.qualityquizzes.quiz.model;

public class Teacher extends ApplicationUser {
   // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
   private static final boolean isTeacher = true;
   
   // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
   public Teacher () {
      super();
   }
   
   public Teacher (
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
   
   public Teacher (
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