package com.QualityQuizzes.Quiz.Model;

public class ApplicationUser {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private long id;
    
    private String  email;
    
    private String  firstName;
    private String  lastName;
    
    private String userName;
    
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
    public long getId() {return id;}
}
