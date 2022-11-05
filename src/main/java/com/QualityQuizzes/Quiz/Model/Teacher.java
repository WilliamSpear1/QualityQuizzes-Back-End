package com.QualityQuizzes.Quiz.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name = "teacher")
public class Teacher extends ApplicationUser {
   // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
   @Column
   private static final boolean isTeacher = true;
   
   // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
   Teacher() {}
   
   public Teacher(
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
   
   public Teacher(
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
   public Boolean getStatus() {return isTeacher;}
}