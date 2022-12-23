package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.model.ApplicationUser;

import java.util.List;

public interface UserDAO <Users> {
    List<Users> getAllUsers();
    ApplicationUser getById(long Id);
    Users  addUser (final Users user);
    void updateUser (final Users user);
    void deleteUser (long Id);
}
