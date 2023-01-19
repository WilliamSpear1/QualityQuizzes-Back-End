package com.qualityquizzes.quiz.dao;

import com.qualityquizzes.quiz.model.QuizQuestion;

import java.util.List;

public interface QuizQuestionDAO {
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    List<QuizQuestion> getQuestionsByQuizId(final long quizId);
   
    QuizQuestion getQuestionById(final long id);
  
    void addQuizQuestion(final QuizQuestion quizQuestion);
    
    void updateQuizQuestion (final QuizQuestion quizQuestion, final long id);
    
    void deleteQuizQuestions (final long id);
}
