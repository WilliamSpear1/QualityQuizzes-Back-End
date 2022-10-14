package com.QualityQuizzes.Quiz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity (name = "ApplicationUser")
@Table (name = "ApplicationUser")
public class ApplicationUser {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Id
    @SequenceGenerator(
      name           = "user_sequence",
      sequenceName   = "user_sequence"
    )

    @GeneratedValue(
      strategy  = GenerationType.SEQUENCE,
      generator = "user_sequence"
    )

    @Column(
      name      = "user_id",
      updatable = false
    )
    private Long    id;
    @Column(
      name             = "email",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String  email;
    
    @Column(
      name             = "first_name",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String  firstName;
    @Column(
      name             = "last_name",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String  lastName;
    
    // Methods /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ApplicationUser() {
        firstName = "";
        lastName  = "";
    }
    
    ApplicationUser(
      String  firstName,
      String  lastName,
      Long    id
    ) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.id        = id;
    }
    
    // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
    public void setEmailName(String userEmail)  {this.email      = email;}
    public void setFirstName(String firstName) {this.firstName  = firstName;}
    public void setLastName(String lastName)   {this.lastName   = lastName;}
    
    public String getEmail()     {return email;}
    public String getFirstName() {return firstName;}
    public String getLastName()  {return lastName;}
}