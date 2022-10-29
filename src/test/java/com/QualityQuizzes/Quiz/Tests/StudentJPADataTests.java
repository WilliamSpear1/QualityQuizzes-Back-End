package com.QualityQuizzes.Quiz.Tests;

import com.QualityQuizzes.Quiz.Model.Student;
import com.QualityQuizzes.Quiz.Repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class StudentJPADataTests {
    // Members ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Autowired
    private TestEntityManager testEntityManager;
    
    @Autowired
    StudentRepository studentRepository;
    
    // Methods ////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void should_store_a_student() {
        Student student= new Student(
         "Will",
         "Spearman",
         "Spear1",
         "Spear1@gmail.com"
       );
       
       studentRepository.save(student);
    
        assertThat(student).hasFieldOrPropertyWithValue("email", "Spear1@gmail.com");
        assertThat(student).hasFieldOrPropertyWithValue("firstName", "Will");
        assertThat(student).hasFieldOrPropertyWithValue("lastName", "Spearman");
        assertThat(student).hasFieldOrPropertyWithValue("userName", "Spear1");
    }
    
    @Test
    public void should_delete_student_by_Id() {
        Student student1 = new Student(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        testEntityManager.persist(student1);
        
        Student student2 = new Student(
          "Bret",
          "Steadman",
          "Steadman1",
          "Steadman1@gmail.com"
        );
        testEntityManager.persist(student2);
    
        Student student3 = new Student(
          "Damon",
          "Akins",
          "Akins1",
          "Akins1@gmail.com"
        );
        testEntityManager.persist(student3);
    
        studentRepository.deleteById(student3.getId());
        
        Iterable<Student> students = studentRepository.findAll();
        
        assertThat(students).asList().hasSize(2).contains(student1, student2);
    }
    
    @Test
    public void should_delete_all_students() {
        Student student1 = new Student(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        testEntityManager.persist(student1);
        
        Student student2 = new Student(
          "Bret",
          "Steadman",
          "Steadman1",
          "Steadman1@gmail.com"
        );
        testEntityManager.persist(student2);
        
        Student student3 = new Student(
          "Damon",
          "Akins",
          "Akins1",
          "Akins1@gmail.com"
        );
        testEntityManager.persist(student3);
    
        Iterable<Student> students = studentRepository.findAll();
    
        assertThat(students).asList().hasSize(3).contains(student1, student2, student3);
        
        studentRepository.deleteAll();
        
        Iterable<Student> noStudents = studentRepository.findAll();
        
        assertThat(noStudents).asList().isEmpty();
    }
    // TODO: check if this logic makes sense.
    @Test
    public void should_update_student_by_Id() {
        Student student1 = new Student(
          "Will",
          "Spearman",
          "Spear1",
          "Spear1@gmail.com"
        );
        testEntityManager.persist(student1);
    
        Student student2 = new Student(
          "Bret",
          "Steadman",
          "Steadman1",
          "Steadman1@gmail.com"
        );
        testEntityManager.persist(student2);
        
        Student updatedStudent = new Student(
          "New Will",
          "New Spearman",
          "New Spear1",
          "New Spear1@gmail.com"
        );
        
        Student student = studentRepository.findById(student1.getId()).get();
        
        student.setFirstName (updatedStudent.getFirstName());
        student.setLastName  (updatedStudent.getLastName());
        student.setUserName  (updatedStudent.getUserName());
        student.setEmailName (updatedStudent.getEmail());
        studentRepository.save(student);
        
        Student checkStudent = studentRepository.findById(student.getId()).get();
    
        assertThat(checkStudent.getId())
          .isEqualTo(student1.getId());
        assertThat(checkStudent.getFirstName())
          .isEqualTo(student1.getFirstName());
        assertThat(checkStudent.getLastName())
          .isEqualTo(student1.getLastName());
        assertThat(checkStudent.getUserName())
          .isEqualTo(student1.getUserName());
    }
   
   @Test
   public void should_find_student_by_Id() {
       Student student1 = new Student(
         "Will",
         "Spearman",
         "Spear1",
         "Spear1@gmail.com"
       );
       testEntityManager.persist(student1);
    
       Student student2 = new Student(
         "Bret",
         "Steadman",
         "Steadman1",
         "Steadman1@gmail.com"
       );
       testEntityManager.persist(student2);
       
       Student foundStudent = studentRepository.findById(student2.getId()).get();
       
       assertThat(foundStudent).isEqualTo(student2);
    }
}