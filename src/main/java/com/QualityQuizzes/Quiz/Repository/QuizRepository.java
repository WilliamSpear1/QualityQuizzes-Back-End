package com.QualityQuizzes.Quiz.Repository;

import com.QualityQuizzes.Quiz.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByQuizName (String quizName);
}
