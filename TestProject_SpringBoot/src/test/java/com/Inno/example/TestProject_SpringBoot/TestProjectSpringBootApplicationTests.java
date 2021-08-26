package com.Inno.example.TestProject_SpringBoot;

import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.Inno.example.TestProject_SpringBoot.model.Student;
import com.Inno.example.TestProject_SpringBoot.repository.StudentRepository;
import com.Inno.example.TestProject_SpringBoot.service.StudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
class TestProjectSpringBootApplicationTests {
	@Autowired
	private StudentService studentService;
	@MockBean
	private StudentRepository studentRepository;

	@Test
	public void getStudentsRecordsTest() {
		when(studentRepository.findAll())
				.thenReturn(Stream
						.of(new Student("201", "Jery", "Val", "9324758465", "Bangalore"),
								new Student("202", "Sunaina", "Teja", "9324758245", "Nagole"))
						.collect(Collectors.toList()));
		assertEquals(2, studentService.getStudentRecords().size());
	}

	@Test
	public void getStudentRecordByIdTest() {
		String id = "201";
		Student student = new Student("201", "Jery", "Val", "9324758465", "Bangalore");
		when(studentRepository.save(student)).thenReturn(student);
		assertEquals(id, studentService.saveStudent(student).getId());
	}

	@Test
	public void saveStudentTest() {
		Student student = new Student("205", "Ram", "Dev", "9325658465", "Nellore");
		when(studentRepository.save(student)).thenReturn(student);
		assertEquals(student, studentService.saveStudent(student));
	}

	@Test
	public void deleteStudentTest() {
		String id = "205";
		Student student = new Student("205", "Ram", "Dev", "9325658465", "Nellore");
		when(studentRepository.save(student)).thenReturn(student);
		studentService.saveStudent(student);
		Student student1=studentRepository.findById(id).get();
		studentRepository.deleteById(student1.getId());
		Student deletedstudent=studentRepository.findById(id).get();
		assertThat(deletedstudent).isNull();
	}
}
