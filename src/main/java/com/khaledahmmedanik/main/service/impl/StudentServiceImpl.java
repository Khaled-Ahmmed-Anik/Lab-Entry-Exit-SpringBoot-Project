package com.khaledahmmedanik.main.service.impl;

import java.util.List;

import java.text.SimpleDateFormat;  
import java.util.Date;


import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.khaledahmmedanik.main.entity.Student;
import com.khaledahmmedanik.main.repository.StudentRepository;
import com.khaledahmmedanik.main.service.StudentService;


@Service
public class StudentServiceImpl implements StudentService {

	
		
	private StudentRepository studentRepository;
	
	
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll(Sort.by(Sort.Direction.DESC, "entryTime"));
	}


	@Override
	public Student saveStudent(Student student) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss\ndd/MM/yyyy");  
	    Date date = new Date();  
	    String realTime= formatter.format(date);
	    student.setEntryTime(realTime);
	    student.setIn(true);
		return studentRepository.save(student);
	}


	@Override
	public Student getStudentById(String id) {                                                  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
		
		return studentRepository.getStudentById(id);
	}


	@Override
	public Student updateLeavingTime(Student existingStudnet) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss\ndd/MM/yyyy");  
	    Date date = new Date();  
	    String realTime= formatter.format(date);
	    existingStudnet.setExitTime(realTime);
	    existingStudnet.setIn(false);
	    studentRepository.save(existingStudnet);
	    return null;
	}


	@Override
	public int getTotalBookedSeatNumber(String exitTime) {
		
		return studentRepository.getTotalBookedSeatNumber(exitTime);
	}


	@Override
	public List<Student> getStudentListById(String id) {
		return studentRepository.getStudentListById(id);
	}


	@Override
	public void deleteStudent(String id) {
		studentRepository.deleteStudent(id);
		
	}


	

}