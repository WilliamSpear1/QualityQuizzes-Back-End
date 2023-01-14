package com.qualityquizzes.quiz.dao;

import com.qualityquizzes.quiz.model.Quiz;

public interface QuizDAO {
 Quiz getQuizById (final long id);
 
 Quiz addQuiz (final Quiz quiz);
 
 void updateQuiz (final Quiz quiz);
 
 void deleteQuiz (final long Id);
}
