package com.QualityQuizzes.Quiz.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "teacher")
public class Teacher extends ApplicationUser {
   // Constants ///////////////////////////////////////////////////////////////////////////////////////////////////////
   private static final boolean isTeacher = true;

   // Members /////////////////////////////////////////////////////////////////////////////////////////////////////////
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_generator")
   private long   id;
   @Column(
    name             = "teacher_user_name",
    nullable         = false,
    columnDefinition = "TEXT"
   )
   private String teacherUserName;
   
   @Column(
    name = "teacher_email",
    nullable = false,
    columnDefinition = "TEXT"
   )
   private String teacherEmail;
   
   @Column(
    name = "teacher_first_name",
    nullable = false,
    columnDefinition = "TEXT"
   )
   private String teacherFirstName;
   
   @Column(
    name = "teacher_last_name",
    nullable = false,
    columnDefinition = "TEXT"
   )
   private String teacherLastName;
   
   // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
   Teacher() {}
   public Teacher(
     String teacherFirstName,
     String teacherLastName,
     String teacherUserName,
     String teacherEmail,
     Long   id
   ) {
        super(
            teacherFirstName,
            teacherLastName,
            teacherUserName,
            teacherEmail,
            id
        );
   }
   
   public Teacher(
     String teacherFirstName,
     String teacherLastName,
     String teacherUserName,
     String teacherEmail
   ) {
      super(
        teacherFirstName,
        teacherLastName,
        teacherUserName,
        teacherEmail
      );
   }
   public Boolean getStatus() {return isTeacher;}
}