package com.QualityQuizzes.Quiz.dao;

import com.QualityQuizzes.Quiz.model.Quiz;

public interface QuizDAO {
 Quiz getQuizById (final long id);
 
 Quiz addQuiz (final Quiz quiz);
 
 void updateQuiz (final Quiz quiz);
 
 void deleteQuiz (final long Id);
}
