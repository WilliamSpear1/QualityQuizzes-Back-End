package com.QualityQuizzes.Quiz.Repository;

import com.QualityQuizzes.Quiz.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
