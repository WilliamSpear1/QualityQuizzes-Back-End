package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.model.ApplicationUser;

import java.util.List;

public interface UserDAO <Users> {
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    List<Users> getAllUsers ();
    
    Users getById (long Id);
    
    Users  addUser (final Users user);
    
    void updateUser (Users user, long Id);
    
    void deleteUser (long Id);
}
