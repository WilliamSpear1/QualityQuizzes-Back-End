package com.QualityQuizzes.Quiz.Model;

import javax.persistence.Embeddable;

@Embeddable
public class QuizQuestion {
    String question;
    String correctAnswer;
    String incorrectAnswer;
    
    public QuizQuestion(){}
    public QuizQuestion(
      String question,
      String correctAnswer,
      String incorrectAnswer
    ){
        this.question        = question;
        this.correctAnswer   = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
    }
}