package com.ty.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

	@GetMapping("/fetched")
	public String getMsg() {
		return "Record fetched";
	}
	
	@PostMapping("/register")
	public String greetMsg() {
		return "save Record";
	}
	
	@DeleteMapping("/del")
	public String deleteRecord() {
		return "Record deleted";
	}
	
	@PutMapping("/updated")
	public String update() {
		return "Updated";
	}
	
	@PatchMapping("/updatedName")
	public String updateName() {
		return "Name is updated";
	}
}
