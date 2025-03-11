package com.ty.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MsgController {

	@GetMapping("/fetch")
	public String getMsg() {
		return "Record fetched";
	}
	
	@PostMapping("/reg")
	public String greetMsg() {
		return "save Record";
	}
	
	@DeleteMapping("/delete")
	public String deleteRecord() {
		return "Record deleted";
	}
	
	@PutMapping("/update")
	public String update() {
		return "Updated";
	}
	
	@PatchMapping("/updateName")
	public String updateName() {
		return "Name is updated";
	}
	
}
