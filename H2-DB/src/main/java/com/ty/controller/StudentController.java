package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.ty.entity.Student;
import com.ty.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student	student) {
		Student dbStudent = studentService.save(student);
		
		ResponseEntity<Student> re = new ResponseEntity<Student>(dbStudent, HttpStatus.CREATED);
		
		return re;
	}
	
	@GetMapping("/get")
	public ResponseEntity<Student> getStudent(@RequestParam Integer sid) {
		
		Student student = studentService.findBySid(sid);
		
//		return new ResponseEntity<Student>(student, HttpStatus.OK);
		
		return ResponseEntity.ok(student);
	}
	
	
}
