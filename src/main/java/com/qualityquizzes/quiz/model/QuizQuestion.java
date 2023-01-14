package com.qualityquizzes.quiz.model;

public class QuizQuestion {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    private String question;
    
    private String correctAnswer;
    
    private String incorrectAnswer;
    
    private long id;
    
    private long quizId;
    
    // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
    public QuizQuestion(){}
    
    public QuizQuestion(
      String question,
      String correctAnswer,
      String incorrectAnswer,
      long quizId
    ){
        this.question        = question;
        this.correctAnswer   = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
        this.quizId          = quizId;
    }
    
    public QuizQuestion(
        String question,
        String correctAnswer,
        String incorrectAnswer,
        long id,
        long quizId
    ){
        this.question        = question;
        this.correctAnswer   = correctAnswer;
        this.incorrectAnswer = incorrectAnswer;
        this.id              = id;
        this.quizId          = quizId;
    }
    
    // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
    public String getQuestion        () {return question;}
    
    public String getCorrectAnswer   () {return correctAnswer;}
    
    public String getIncorrectAnswer () {return incorrectAnswer;}
    
    public long getId ()                {return id;}
    
    public long getQuizId ()            {return quizId;}
    
    public void setQuestion (final String question)              {this.question = question;}
    
    public void setCorrectAnswer(final String correctAnswer)     {this.correctAnswer = correctAnswer;}
    
    public void setIncorrectAnswer(final String incorrectAnswer) {this.incorrectAnswer = incorrectAnswer;}
    
    public void setId(final long id)                             {this.id = id;}
    
    public void setQuizId(final long id)                         {this.quizId = quizId;}
}