package com.ty.cp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.cp.entity.Enquiry;
import com.ty.cp.enums.ClassMode;
import com.ty.cp.enums.Course;
import com.ty.cp.enums.Status;
import com.ty.cp.service.EnquiryService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/enq")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4000" })
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;

	@PostMapping("/add/{cid}")
	public ResponseEntity<String> postMethodName(@PathVariable Integer cid, @RequestBody Enquiry enquiry) {

		return enquiryService.addEnquiry(cid, enquiry);
	}

	@PutMapping("/mode/{id}")
	public ResponseEntity<String> updateClassMode(@PathVariable Integer id, @RequestParam ClassMode classMode) {

		return enquiryService.updateClassMode(id, classMode);
	}

	@GetMapping("/course")
	public ResponseEntity<List<Enquiry>> getByCourse(@RequestParam Course course) {

		return enquiryService.getByCourse(course);
	}

	@GetMapping("/status")
	public ResponseEntity<List<Enquiry>> getByStatus(@RequestParam Status status) {

		return enquiryService.getByStatus(status);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEnq(@PathVariable Integer id) {

		return enquiryService.deleteEnq(id);
	}

}
