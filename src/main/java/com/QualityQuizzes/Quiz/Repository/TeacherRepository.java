package com.QualityQuizzes.Quiz.Repository;

import com.QualityQuizzes.Quiz.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findByTeacher (boolean isTeacher);
}
