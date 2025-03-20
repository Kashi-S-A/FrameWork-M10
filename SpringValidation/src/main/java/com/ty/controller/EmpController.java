package com.ty.controller;

import org.springframework.web.bind.annotation.RestController;

import com.ty.entity.Employee;
import com.ty.repo.EmpRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmpController {

	@Autowired
	private EmpRepo empRepo;

	@PostMapping("/save")
	public Employee saveEmployee(@RequestBody Employee employee) {
		Employee save = empRepo.save(employee);
		return save;
	}

}
