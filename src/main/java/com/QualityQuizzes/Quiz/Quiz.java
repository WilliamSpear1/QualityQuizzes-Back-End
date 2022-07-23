package com.QualityQuizzes.Quiz;

import java.util.List;

public class Quiz {
    //  Inner class of QuizQuestions that will populate a Quiz.
    private static class QuizQuestions {
        // Members ////////////////////////////////////////////////////////////////////////////////////////////////////
       private String questionName;
       private  int    questionNumber;
       private  String questionType;

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
    private String              quizName;
    private List<QuizQuestions> quizQuestions;
    private int                 quizQuestionAmount;

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