package com.QualityQuizzes.Quiz.Tests;

import com.QualityQuizzes.Quiz.Model.Teacher;
import com.QualityQuizzes.Quiz.Repository.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class TeacherJPADataTests {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private TestEntityManager testEntityManager;
    
    @Autowired
    TeacherRepository teacherRepository;
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void should_store_a_teacher() {
        Teacher teacher= new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        
        teacherRepository.save(teacher);
        
        assertThat(teacher).hasFieldOrPropertyWithValue("email", "Spear1@gmail.com");
        assertThat(teacher).hasFieldOrPropertyWithValue("firstName", "Will");
        assertThat(teacher).hasFieldOrPropertyWithValue("lastName", "Spearman");
        assertThat(teacher).hasFieldOrPropertyWithValue("userName", "Spear1");
    }
    
    @Test
    public void should_delete_teacher_by_Id() {
        Teacher teacher1 = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        testEntityManager.persist(teacher1);
        
        Teacher teacher2 = new Teacher(
          "Bret",
          "Steadman",
          "Steadman1",
          "Steadman1@gmail.com"
        );
        testEntityManager.persist(teacher2);
        
        Teacher teacher3 = new Teacher(
          "Damon",
          "Akins",
          "Akins1",
          "Akins1@gmail.com"
        );
        testEntityManager.persist(teacher3);
        
        teacherRepository.deleteById(teacher3.getId());
        
        Iterable<Teacher> teachers = teacherRepository.findAll();
        
        assertThat(teachers).asList().hasSize(2).contains(teacher1, teacher2);
    }
    
    @Test
    public void should_delete_all_teachers() {
        Teacher teacher1 = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        testEntityManager.persist(teacher1);
        
        Teacher teacher2 = new Teacher(
          "Bret",
          "Steadman",
          "Steadman1",
          "Steadman1@gmail.com"
        );
        testEntityManager.persist(teacher2);
        
        Teacher teacher3 = new Teacher(
          "Damon",
          "Akins",
          "Akins1",
          "Akins1@gmail.com"
        );
        testEntityManager.persist(teacher3);
        
        Iterable<Teacher> teachers = teacherRepository.findAll();
        
        assertThat(teachers).asList().hasSize(3).contains(teacher1, teacher2, teacher3);
        
        teacherRepository.deleteAll();
        
        Iterable<Teacher> noTeachers = teacherRepository.findAll();
        
        assertThat(noTeachers).asList().isEmpty();
    }
    // TODO: check if this logic makes sense.
    @Test
    public void should_update_teacher_by_Id() {
        Teacher teacher1 = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        testEntityManager.persist(teacher1);
        
        Teacher teacher2 = new Teacher(
          "Bret",
          "Steadman",
          "Steadman1",
          "Steadman1@gmail.com"
        );
        testEntityManager.persist(teacher2);
        
        Teacher updatedTeacher = new Teacher(
          "New Will",
          "New Spearman",
          "New Spear1",
          "New Spear1@gmail.com"
        );
        
        Teacher teacher = teacherRepository.findById(teacher1.getId()).get();
        
        teacher.setFirstName (updatedTeacher.getFirstName());
        teacher.setLastName  (updatedTeacher.getLastName());
        teacher.setUserName  (updatedTeacher.getUserName());
        teacher.setEmailName (updatedTeacher.getEmail());
        teacherRepository.save(teacher);
        
        Teacher checkTeacher = teacherRepository.findById(teacher.getId()).get();
        
        assertThat(checkTeacher.getId())
          .isEqualTo(teacher1.getId());
        assertThat(checkTeacher.getFirstName())
          .isEqualTo(teacher1.getFirstName());
        assertThat(checkTeacher.getLastName())
          .isEqualTo(teacher1.getLastName());
        assertThat(checkTeacher.getUserName())
          .isEqualTo(teacher1.getUserName());
    }
    
    @Test
    public void should_find_teacher_by_Id() {
        Teacher teacher1 = new Teacher(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        testEntityManager.persist(teacher1);
        
        Teacher teacher2 = new Teacher(
          "Bret",
          "Steadman",
          "Steadman1",
          "Steadman1@gmail.com"
        );
        testEntityManager.persist(teacher2);
        
        Teacher foundTeacher = teacherRepository.findById(teacher2.getId()).get();
        
        assertThat(foundTeacher).isEqualTo(teacher2);
    }
}