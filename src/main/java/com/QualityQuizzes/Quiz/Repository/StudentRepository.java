package com.QualityQuizzes.Quiz.Repository;

import com.QualityQuizzes.Quiz.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    // Methods /////////////////////////////////////////////////////////////////////////////////////////////////////
    List<Student> findByUserName (String username);
    List<Student> findByStudent  (boolean isStudent);
}
