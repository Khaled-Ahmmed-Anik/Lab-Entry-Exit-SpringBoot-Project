package com.khaledahmmedanik.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.khaledahmmedanik.main.entity.Student;
import com.khaledahmmedanik.main.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String listStudnets(Model model, Model bookedSeat) {
		model.addAttribute("students", studentService.getAllStudents());
		bookedSeat.addAttribute("seatBooked", studentService.getTotalBookedSeatNumber(""));
		
		return "students";
	}

	@GetMapping("/students/enter")
	public String createStudentForm(Model model) {

		// create student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "enterNewStudent";

	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		student.setExitTime("");
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping( "/students/{id}") 
	public String update(@PathVariable String id, Model model) { 
		
		Student existingStudnet= studentService.getStudentById(id);
		
		studentService.updateLeavingTime(existingStudnet);
		
		return "redirect:/students";
	 }

			

}
