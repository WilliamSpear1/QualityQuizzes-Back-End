package com.QualityQuizzes.Quiz;

import java.util.List;
// TODO: Make class a JPA Entity along with creation of TABLES, COLUMNS, AND MORE.

public class Quiz {
    //  Inner class of QuizQuestions that will populate a Quiz.
    private static class QuizQuestions {
        // Members ////////////////////////////////////////////////////////////////////////////////////////////////////
       final private String  questionName;
       final private  int    questionNumber;
       final private  String questionType;

       // Methods /////////////////////////////////////////////////////////////////////////////////////////////////////
        QuizQuestions (
            String questionName,
            int    questionNumber,
            String questionType
        ) {
            this.questionName   = questionName;
            this.questionNumber = questionNumber;
            this.questionType   = questionType;
        }

        // Setters and Getters ////////////////////////////////////////////////////////////////////////////////////////
        public String getQuestionName()   {return  questionName;}
        public int    getQuestionNumber() {return  questionNumber;}
        public String getQuestionType()   {return  questionType;}
    }

    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    final private String              quizName;
    final private List<QuizQuestions> quizQuestions;
    final private int                 quizQuestionAmount;

    //Methods /////////////////////////////////////////////////////////////////////////////////////////////////////////
    Quiz(
            String              quizName,
            List<QuizQuestions> quizQuestions,
            int                 quizQuestionAmount
    ) {
        this.quizName           = quizName;
        this.quizQuestions      = quizQuestions;
        this.quizQuestionAmount = quizQuestionAmount;
    }
}