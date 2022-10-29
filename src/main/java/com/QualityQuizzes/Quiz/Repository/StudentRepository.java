package com.QualityQuizzes.Quiz.Repository;

import com.QualityQuizzes.Quiz.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // Methods /////////////////////////////////////////////////////////////////////////////////////////////////////
}
