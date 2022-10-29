package com.QualityQuizzes.Quiz.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ApplicationUser {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    private long   id;
    
    @Column(
      name             = "user_name",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String userName;
    
    @Column(
      name             = "first_name",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String firstName;
    
    @Column(
      name             = "last_name",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String lastName;
    
    @Column(
      name             = "email",
      nullable         = false,
      columnDefinition = "TEXT"
    )
    private String email;
    
    // Methods /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ApplicationUser() {
        firstName = "";
        lastName  = "";
        userName  = "";
        email     = "";
    }
    
    ApplicationUser(
      String  firstName,
      String  lastName,
      String  userName,
      String  email
    ) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.userName  = userName;
        this.email     = email;
    }
    
    ApplicationUser(
      String  firstName,
      String  lastName,
      String  userName,
      String  email,
      Long    id
    ) {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.userName  = userName;
        this.email     = email;
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
    
    public long getId()          {return id;}
}