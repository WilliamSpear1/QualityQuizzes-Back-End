package com.qualityquizzes.quiz.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Quiz {
        // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
        private long   id;
        
        private List<QuizQuestion> quizQuestions = new ArrayList<QuizQuestion>();
        
        private String quizName;
        
        private int quizSize;
        
        // Constructors ///////////////////////////////////////////////////////////////////////////////////////////////////
        public Quiz() {}
        
        public Quiz(String quizName, int quizSize) {
                this.quizSize = quizSize;
                this.quizName = quizName;
        }
        
        public Quiz(long id, String quizName, int quizSize) {
                this.id       = id;
                this.quizSize = quizSize;
                this.quizName = quizName;
        }
        
        public Quiz(String quizName, int quizSize, List<QuizQuestion> quizQuestions) {
                this.quizName      = quizName;
                this.quizSize      = quizSize;
                this.quizQuestions = quizQuestions;
        }
        
        public Quiz(long id, String quizName, int quizSize, List<QuizQuestion> quizQuestions) {
                this.id            = id;
                this.quizName      = quizName;
                this.quizSize      = quizSize;
                this.quizQuestions = quizQuestions;
        }
        
        
        // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
        public void addQuizQuestion(final QuizQuestion quizQuestion) {
                quizQuestions.add(
                    new QuizQuestion(
                        quizQuestion.getQuestion(),
                        quizQuestion.getCorrectAnswer(),
                        quizQuestion.getIncorrectAnswer(),
                        quizQuestion.getQuizId()
                    )
                );
                quizSize++;
        }
        
        public void addQuizQuestions(Set<QuizQuestion> quizQuestions) { quizQuestions.forEach(this::addQuizQuestion); }
        
        // Setters and Getters /////////////////////////////////////////////////////////////////////////////////////////////
        public List<QuizQuestion> getQuizQuestions() {
                return quizQuestions;
        }
        
        public String getQuizName () { return quizName; }
        
        public int getQuizSize    () {return quizSize;}
        
        public Long getId         () {return id;}
        
        public void setQuizName (final String quizName) { this.quizName = quizName; }
        
        public void setQuizSize (final int quizSize)    { this.quizSize = quizSize; }
        
        public void setId (final long id)               {this.id = id; }
}
