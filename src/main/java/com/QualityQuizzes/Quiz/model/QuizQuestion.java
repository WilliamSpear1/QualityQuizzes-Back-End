package com.QualityQuizzes.Quiz.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QuizQuestion {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Column
    String question;
    
    @Column
    String correctAnswer;
    
    @Column
    String incorrectAnswer;
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    
    public String getQuestion() {return question;}
    public String getCorrectAnswer() {return correctAnswer;}
    public String getIncorrectAnswer() {return incorrectAnswer;}
}