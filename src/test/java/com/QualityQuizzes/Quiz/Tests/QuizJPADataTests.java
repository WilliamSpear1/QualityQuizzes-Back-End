package com.QualityQuizzes.Quiz.Tests;

import com.QualityQuizzes.Quiz.Model.Quiz;
import com.QualityQuizzes.Quiz.Model.QuizQuestion;
import com.QualityQuizzes.Quiz.Repository.QuizRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class QuizJPADataTests {
    @Autowired
    private TestEntityManager testEntityManager;
    
    @Autowired
    private QuizRepository quizRepository;
    
    @Test
    public void should_store_a_quiz() {
        Quiz quiz = new Quiz("Quiz1", 0);
       
        Set<QuizQuestion> quizQuestions = new HashSet<>();
        
        QuizQuestion question1 = new QuizQuestion(
          "Who is there?",
          "Will",
          "Bret"
        );
        quizQuestions.add(question1);
        
        QuizQuestion question2 = new QuizQuestion(
          "Where is Tallahassee located?",
          "Florida",
          "Georgia"
        );
        quizQuestions.add(question2);
      
        quiz.addQuizQuestions(quizQuestions);
        
        quizRepository.save(quiz);
    
        assertThat(quiz).hasFieldOrPropertyWithValue("quizName", "Quiz1");
        assertThat(quiz).hasFieldOrPropertyWithValue("quizSize", 2);
    }
    
    @Test
    public void should_delete_by_Id() {
        Quiz quiz1 = new Quiz("Quiz1", 0);
    
        Set<QuizQuestion> quizQuestions = new HashSet<>();
    
        QuizQuestion question1 = new QuizQuestion(
          "Who is there?",
          "Will",
          "Bret"
        );
        quizQuestions.add(question1);
    
        QuizQuestion question2 = new QuizQuestion(
          "Where is Tallahassee located?",
          "Florida",
          "Georgia"
        );
        quizQuestions.add(question2);
    
        quiz1.addQuizQuestions(quizQuestions);
        
        testEntityManager.persist(quiz1);
        
        Quiz quiz2 = new Quiz("Quiz2");
    
        QuizQuestion question3 = new QuizQuestion(
          "Who is the president?",
          "Biden",
          "Bush"
        );
        quiz2.addQuizQuestion(question3);
    
        testEntityManager.persist(quiz2);
        
        quizRepository.deleteById(quiz1.getId());
        
        Iterable<Quiz> quizzes = quizRepository.findAll();
        
        assertThat(quizzes).asList().hasSize(1).contains(quiz2);
    }
}
