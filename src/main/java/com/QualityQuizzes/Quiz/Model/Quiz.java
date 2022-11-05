package com.QualityQuizzes.Quiz.Model;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "Quiz")
public class Quiz {
        // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quiz_generator")
        private long   id;
        
        @ElementCollection(fetch = FetchType.LAZY)
        @CollectionTable(name = "quiz_questions",joinColumns = @JoinColumn(name = "quiz_id"))
        @Column(name = "quiz_questions")
        Set<QuizQuestion> quizQuestions = new HashSet<QuizQuestion>();
        
        @Column
        String quizName;
        
        @Column
        int quizSize;
        
        // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
        Quiz () {}
        
        public Quiz(String quizName) {
                this.quizSize = 0;
                this.quizName = quizName;
        }
        
        public Quiz(String quizName, int quizSize) {
               this.quizSize = quizSize;
               this.quizName = quizName;
        }
        
        public Quiz(String quizName, int quizSize, Set<QuizQuestion> quizQuestions) {
                this.quizName      = quizName;
                this.quizSize      = quizSize;
                this.quizQuestions = quizQuestions;
        }
        
        public Set<QuizQuestion> getQuizQuestions() {
                return quizQuestions;
        }
        public boolean addQuizQuestion(QuizQuestion quizQuestion) {
                if (quizQuestions.add(
                  new QuizQuestion(
                     quizQuestion.getQuestion(),
                     quizQuestion.getCorrectAnswer(),
                     quizQuestion.getIncorrectAnswer()
                  )
                )){
                  quizSize++;
                  return true;
                }
                return false;
        }
        
        public void addQuizQuestions(Set<QuizQuestion> quizQuestions) {
                quizQuestions.forEach(this::addQuizQuestion);
        }
        
        public String getQuizName() { return quizName; }
        
        public int getQuizSize()    {return quizSize;}
        
        public Long getId()         {return id;}
        public void setQuizName(String quizName) { this.quizName = quizName; }
}
