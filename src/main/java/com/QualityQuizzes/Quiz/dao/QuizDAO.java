package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.model.Quiz;

import java.util.List;

public interface QuizDAO {
 List<Quiz> getAllQuizQuestions ();
 
 Quiz addQuiz (final Quiz quiz);
 
 void updateQuiz (Quiz quiz, long Id);
 
 void deleteQuiz (long Id);
}
