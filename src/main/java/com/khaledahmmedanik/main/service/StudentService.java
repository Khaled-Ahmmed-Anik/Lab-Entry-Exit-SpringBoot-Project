package com.khaledahmmedanik.main.service;

import java.util.List;

import org.springframework.ui.Model;

import com.khaledahmmedanik.main.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	
	Student saveStudent(Student student);


	Student getStudentById(String id);


	Student updateLeavingTime(Student existingStudnet);




	int getTotalBookedSeatNumber(String string);


	
	
}