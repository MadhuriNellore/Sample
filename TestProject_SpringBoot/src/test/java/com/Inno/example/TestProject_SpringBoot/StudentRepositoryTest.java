package com.Inno.example.TestProject_SpringBoot;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.Inno.example.TestProject_SpringBoot.model.Student;
import com.Inno.example.TestProject_SpringBoot.repository.StudentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentRepositoryTest {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
    private TestEntityManager entityManager;
     
	@Test
    public void testSaveStudent() {
        entityManager.persist(new Student("201", "Jery", "Val", "9324758465", "Bangalore"));
                 
       Student student = studentRepository.findById("201").get();
         
       assertThat(student.getId()).isEqualTo("201");
    }
	@Test
	public void testListStudents() {
	    List<Student> students = (List<Student>) studentRepository.findAll();
	    assertThat(students).size().isGreaterThan(0);
	}
	@Test
	public void testGetStudentById() {
		 Student student = studentRepository.findById("101").get();    
	    assertThat(student.getId()).isEqualTo("101");
	}
	@Test
	@Rollback(false)
	public void testUpdateAddress() {
	   Student student = studentRepository.findById("101").get();  
	   student.setAddress("Nellore,Ap");
	     
	   studentRepository.save(student);
	     
	    Student updatedStudent = studentRepository.findById("101").get();
	     
	    assertThat(updatedStudent.getAddress()).isEqualTo("Nellore,Ap");
	}
	@Test
	@Rollback(false)
	public void testDeleteStudent() {
	   Student student = studentRepository.findById("104").get();
	     
	    studentRepository.deleteById(student.getId());
	  Optional<Student> deletedStudent = studentRepository.findById("105");
	    assertThat(deletedStudent).isEmpty();       
	     
	}

}
