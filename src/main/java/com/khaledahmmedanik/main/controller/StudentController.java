package com.khaledahmmedanik.main.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.khaledahmmedanik.main.entity.Student;
import com.khaledahmmedanik.main.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;
	
	private int seatLimit=4;
	
	private boolean isEnterAllowd;
	
	private boolean isFromSearch=false;
	
	private String seatStatusMsg;
	
	private List<Student> searchResult;
	private Student notFound=new Student();
	
	
	

	public StudentController(StudentService studentService) {
		super();
		notFound.setId("Not Found");
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String seatStatusMsg(Model model,Model seatSatutsMsgInView, Model enterAllowedModel) {
		model.addAttribute("students", studentsPageListContent());
		
		int seatBooked=studentService.getTotalBookedSeatNumber("");
		
		if (seatBooked==0) {
			isEnterAllowd=true;
			seatStatusMsg="Lab is empty now...";
		}else if(seatBooked==1) {
			isEnterAllowd=true;
			seatStatusMsg="Only 1 seat is booked";
		}else if(seatBooked==seatLimit){
			isEnterAllowd=false;
			seatStatusMsg="Sorry, no seats available";
		}else {
			isEnterAllowd=true;
			seatStatusMsg=Integer.toString(seatBooked)+" seats are booked (out of "+Integer.toString(seatLimit)+")";
		}
		
		seatSatutsMsgInView.addAttribute("seatStatusMsg", seatStatusMsg);
		enterAllowedModel.addAttribute("enterAllowd",isEnterAllowd);
		isFromSearch=false;
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
		
	
	@PostMapping("/searchAction")
	public String handleSearch(@RequestParam("id") String id ) {
		isFromSearch=true;
		searchResult=studentService.getStudentListById(id);
		return "redirect:/students";
	}

	
	
	
	private List<Student> studentsPageListContent() {
		if(isFromSearch) {
			if (searchResult.size()==0) {
				
				searchResult.add(notFound);
			}
			return searchResult;
		}
		return studentService.getAllStudents();
	}
	
	
	
	@GetMapping( "/students/delete/{id}") 
	public String deleteStudent(@PathVariable String id) { 
		System.out.println(id);
		studentService.deleteStudent(id);
		
		return "redirect:/students";
	 }
			

}