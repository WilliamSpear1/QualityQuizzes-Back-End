package com.QualityQuizzes.Quiz.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table (name = "quiz")
public class Quiz {
    //  Inner class of QuizQuestions that will populate a Quiz.
    private static class QuizQuestions {
        // Members ////////////////////////////////////////////////////////////////////////////////////////////////////
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_generator")
        private long id;
       
        @Column(
         name             = "quiz_name",
         nullable         = false,
         columnDefinition = "TEXT"
       )
       final private String  questionName;
       
       @Column(
         name             = "quiz_number",
         nullable         = false,
         columnDefinition = "TEXT"
       )
       final private  int    questionNumber;
       
       @Column(
         name = "quiz_type",
         nullable = false,
         columnDefinition = "TEXT"
       )
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