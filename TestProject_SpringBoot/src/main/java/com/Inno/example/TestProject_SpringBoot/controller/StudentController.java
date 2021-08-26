package com.Inno.example.TestProject_SpringBoot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Inno.example.TestProject_SpringBoot.model.Student;
import com.Inno.example.TestProject_SpringBoot.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentService studentService;

//	public StudentController(StudentService studentService) {
//		super();
//		this.studentService = studentService;
//	}

	@PostMapping(path = "register", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> registerStudent(@RequestBody Student student) {
		try {
			studentService.saveStudent(student);
			return ResponseEntity.ok("Registered Successful");
		} catch (RuntimeException re) {
			System.out.println(re);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(re.getMessage());
		}
	}

	@PutMapping(path = "update/address")
	public ResponseEntity<String> updateAddress(@RequestBody Student student) {
		studentService.updateAddress(student);
		return ResponseEntity.ok("Updated Successful");
	}

	@GetMapping(path = "records/id")
	public Optional<Student> getRecordById(@RequestParam String id) {
		return studentService.getRecordById(id);
	}
	@GetMapping(path = "records")
	public List<Student> getRecordById() {
		return studentService.getStudentRecords();
	}
	@DeleteMapping(path="delete/id")
	public ResponseEntity<String> deleteStudentById(@RequestParam String id)
	{
		studentService.deleteStudent(id);
		return ResponseEntity.ok("Deleted record Successfully");
	}
	
	
}
