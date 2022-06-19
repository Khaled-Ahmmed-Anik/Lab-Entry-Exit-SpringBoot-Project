package com.khaledahmmedanik.main.service;

import java.util.List;

import com.khaledahmmedanik.main.entity.Admin;
import com.khaledahmmedanik.main.entity.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	
	Student saveStudent(Student student);


	Student getStudentById(String id);


	Student updateLeavingTime(Student existingStudnet);


	int getTotalStudentsInList(boolean b);

	int getTotalBookedSeatNumber(String string);


	List<Student> getStudentListById(String id);


	void deleteStudent(String id);


	Admin getAdminInfo(String string);


	


	void deleteAllStudent(boolean b);


	


	
	
}