package com.Inno.example.TestProject_SpringBoot.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Inno.example.TestProject_SpringBoot.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, String>
{
@Query("update Student s set s.address=?1 where s.id=?2 ")
@Transactional
@Modifying
 int updateAddress(String address, String id);
}
