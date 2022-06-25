package com.QualityQuizzes.Quiz;

public class User {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String userName;
   private String firstName;
   private String lastName;

   // Methods /////////////////////////////////////////////////////////////////////////////////////////////////////////
    User() {
       userName = "";
        firstName =  "";
        lastName = "";
    }

    User(
         String userName,
         String firstName,
         String lastName
    ) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }
   // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
    public void setUserName(String userName) { this.userName = userName;}
    public void setFirstName(String firstName)  { this.firstName  = firstName;}
    public void setLastName(String lastName)    { this.lastName   = lastName;}

    public String getUserName() {return userName;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
}