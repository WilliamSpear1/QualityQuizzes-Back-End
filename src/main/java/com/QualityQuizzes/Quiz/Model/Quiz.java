package com.QualityQuizzes.Quiz.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table (name = "quiz")
public class Quiz {
    // TODO: Figure out what to do with this inner class of questions.
    // TODO: And how it interact as table in the database.
    
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
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_generator")
    private long id;
    
    @ManyToOne (fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "user_id", nullable = false)
    @OnDelete(action =  OnDeleteAction.CASCADE)
    @JsonIgnore
    private ApplicationUser user;
    @Column(
      name = "quiz_name",
      nullable = false,
      columnDefinition = "TEXT"
    )
    final private String              quizName;
    final private List<QuizQuestions> quizQuestions;
    @Column(
      name = "quiz_question_amount",
      nullable = false,
      columnDefinition = "TEXT"
    )
    final private int                 quizQuestionAmount;

    //Methods /////////////////////////////////////////////////////////////////////////////////////////////////////////
    Quiz(
            String              quizName,
            List<QuizQuestions> quizQuestions,
            int                 quizQuestionAmount,
            ApplicationUser     user
    ) {
        this.quizName           = quizName;
        this.quizQuestions      = quizQuestions;
        this.quizQuestionAmount = quizQuestionAmount;
        this.user               = user;
    }
}