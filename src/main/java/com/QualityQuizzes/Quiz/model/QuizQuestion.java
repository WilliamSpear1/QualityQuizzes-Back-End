package com.QualityQuizzes.Quiz.model;

public class QuizQuestion {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String question;
    
    private String correctAnswer;
    
    private String incorrectAnswer;
    
    private long id;
    
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
    
    public void setQuestion (String question) {this.question = question;}
    
    public void setCorrectAnswer(String correctAnswer) {this.correctAnswer = correctAnswer;}
    
    public void setIncorrectAnswer(String incorrectAnswer) {this.incorrectAnswer = incorrectAnswer;}
    
    public void setId(long id) {this.id = id;}
}