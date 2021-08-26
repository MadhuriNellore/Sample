package com.Inno.example.TestProject_SpringBoot.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inno.example.TestProject_SpringBoot.model.Student;
import com.Inno.example.TestProject_SpringBoot.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

//	public StudentService(StudentRepository studentRepository) {
//		super();
//		this.studentRepository = studentRepository;
//	}

	// saving(inserting) the details of a student
	public Student saveStudent(Student student) throws RuntimeException {
		return studentRepository.save(student);
	}

	// update the details
	@Transactional
	public void updateAddress(Student student) {
		System.out.println("Student id: " + student.getId() + "\n updatedAddress: " + student.getAddress());
		studentRepository.updateAddress(student.getAddress(), student.getId());
	}

	// student details by id
	public Optional<Student> getRecordById(String id) {
		return studentRepository.findById(id);
	}

	// All student details
	public List<Student> getStudentRecords() {
		List<Student> list = new ArrayList<Student>();
		studentRepository.findAll().forEach(list::add);
		return list;
	}

	// delete student records
	public void deleteStudent(String id) {
		 studentRepository.deleteById(id);
		 
	}

}
