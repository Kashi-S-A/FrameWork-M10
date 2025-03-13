package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.entity.Student;
import com.ty.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		Student save = studentService.save(student);
		return save;
	}
	
	@GetMapping("/fetch")
	public Student fetchStudent(@RequestParam Integer sid) {
		Student student = studentService.getById(sid);
		return student;
	}
	
	@PutMapping("/update/{sid}")
	public Student putMethodName(@PathVariable Integer sid, @RequestBody Student student) {
		Student updatedStudent = studentService.update(sid,student);
		return updatedStudent;
	}
	
	@DeleteMapping("/delete/{sid}")
	public String deleteStudent(@PathVariable Integer sid) {
		String msg = studentService.deleteStudent(sid);
		return msg;
	}
	
}
