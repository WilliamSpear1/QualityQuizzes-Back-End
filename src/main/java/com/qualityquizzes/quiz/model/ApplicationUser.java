package com.qualityquizzes.quiz.model;

public abstract class ApplicationUser {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private long   id;
    
    private String userName;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    // Constructors /////////////////////////////////////////////////////////////////////////////////////////////////////////
    ApplicationUser() {
        this.id        = 0;
        this.email     = "";
        this.userName  = "";
        this.firstName = "";
        this.lastName  = "";
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
    public void setEmailName (final String email)     {this.email      = email;}
    
    public void setFirstName (final String firstName) {this.firstName  = firstName;}
    
    public void setLastName  (final String lastName)  {this.lastName   = lastName;}
    
    public void setUserName  (final String userName)  {this.userName   = userName;}
    
    public void setId        (final long id)          {this.id         = id;}
    
    public String getEmail     () {return email;}
    
    public String getFirstName () {return firstName;}
    
    public String getLastName  () {return lastName;}
    
    public String getUserName  () {return userName;}
    
    public long getId          () {return id;}
}