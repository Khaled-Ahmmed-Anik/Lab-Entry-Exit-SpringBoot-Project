package com.khaledahmmedanik.main.service;

import java.util.List;

import com.khaledahmmedanik.main.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	
	Student saveStudent(Student student);


	Student getStudentById(String id);


	Student updateLeavingTime(Student existingStudnet);
	
	
}
