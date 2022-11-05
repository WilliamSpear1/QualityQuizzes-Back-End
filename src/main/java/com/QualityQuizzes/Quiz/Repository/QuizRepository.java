package com.QualityQuizzes.Quiz.Repository;

import com.QualityQuizzes.Quiz.Model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
