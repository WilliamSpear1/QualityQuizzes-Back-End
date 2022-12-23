package com.QualityQuizzes.Quiz.model;

public class QuizQuestion {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    String question;
    
    String correctAnswer;
    
    String incorrectAnswer;
    
    // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
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
    
    // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
    public String getQuestion        () {return question;}
    public String getCorrectAnswer   () {return correctAnswer;}
    public String getIncorrectAnswer () {return incorrectAnswer;}
}