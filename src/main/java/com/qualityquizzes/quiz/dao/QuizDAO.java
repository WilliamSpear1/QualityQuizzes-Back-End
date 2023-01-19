package com.qualityquizzes.quiz.dao;

import com.qualityquizzes.quiz.model.Quiz;

public interface QuizDAO {
 // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
 Quiz getQuizById (final long id);
 
 void addQuiz (final Quiz quiz);
 
 void updateQuiz (final Quiz quiz, final long id);
 
 void deleteQuiz (final long Id);
}
