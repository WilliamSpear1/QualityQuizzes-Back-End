package com.qualityquizzes.quiz.dao;

import java.util.List;

public interface UserDAO <Users> {
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    List<Users> getAllUsers ();
    
    Users getById (final long Id);
    
    Users  addUser (final Users user);
    
    void updateUser (final Users user, final long id);
    
    void deleteUser (long Id);
}
