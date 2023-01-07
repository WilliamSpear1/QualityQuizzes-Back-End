package com.QualityQuizzes.Quiz.model;

import java.util.HashSet;
import java.util.Set;

public class Quiz {
        // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
        private long   id;
        
        private Set<QuizQuestion> quizQuestions = new HashSet<QuizQuestion>();
        
        private String quizName;
        
        private int quizSize;
        
        // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
        public Quiz() {}
        
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
        
        
        // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        
        // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
        public Set<QuizQuestion> getQuizQuestions() {
                return quizQuestions;
        }
        
        public String getQuizName () { return quizName; }
        
        public int getQuizSize    () {return quizSize;}
        
        public Long getId         () {return id;}
        
        public void setQuizName (String quizName) { this.quizName = quizName; }
        public void setQuizSize (int quizSize) { this.quizSize = quizSize; }
        public void setId (long id) {this.id = id; }
}
