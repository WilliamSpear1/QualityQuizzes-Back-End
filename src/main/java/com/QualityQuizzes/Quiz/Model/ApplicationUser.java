package com.QualityQuizzes.Quiz.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table  (name = "ApplicationUser")
public class ApplicationUser {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Id
    @GeneratedValue(
      strategy  = GenerationType.SEQUENCE,
      generator = "user_sequence"
    )
    private long id;
    
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
    
    @Column(
      name             = "username",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String userName;
    
    // Methods /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ApplicationUser() {
        firstName = "";
        lastName  = "";
        userName  = "";
    }
    
    ApplicationUser(
      String  firstName,
      String  lastName,
      String  userName,
      Long    id
    ) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.userName  = userName;
        this.id        = id;
    }
    
    // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
    public void setEmailName(String userEmail) {this.email      = email;}
    public void setFirstName(String firstName) {this.firstName  = firstName;}
    public void setLastName(String lastName)   {this.lastName   = lastName;}
    public void setUserName(String userName)   {this.userName   = userName;}
    public String getEmail()     {return email;}
    public String getFirstName() {return firstName;}
    public String getLastName()  {return lastName;}
    public String getUserName()  {return userName;}
}
