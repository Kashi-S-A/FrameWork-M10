package com.ty.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.dto.Student;


@RestController
public class ReadController {

	//URL : http://localhost:8080/read?id=100&name=Dinga
	//Method : GET
	
	@GetMapping("/read")
	public String readData(@RequestParam(name = "id") Integer sid, @RequestParam String name) {
		System.out.println("id : "+sid);
		System.out.println("name : "+name);
		return "id : "+sid+" , name : "+name;
	}
	
	//URL : http://localhost:8080/data/sid/101/phone/1234567/name/Dinga
	//Method : GET
	
	@GetMapping("/data/sid/{sid}/phone/{phone}/name/{name}")
	public String data(@PathVariable(name = "sid") Integer id, @PathVariable Integer phone
			, @PathVariable String name) {
		System.out.println("id : "+id);
		System.out.println("phone : "+phone);
		System.out.println("Name : "+name);
		return "id : "+id+", phone : "+phone+" , name : "+name;
	}
	
	
	@GetMapping("/head")
	public String getToken(@RequestHeader String token) {
		System.out.println("Token : "+token);
		return "Read Token";
	}
	
	@GetMapping("/body")
	public Student readDataFromBody(@RequestBody Student student) {
		System.out.println(student);
		return student;
	}
	
	
	
}
