package com.ty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	//save employee
	public void save(Employee  employee) {
		employeeRepository.save(employee);
	}
	
	//pagination
	
	public List<Employee> pagination(int pageNumber) {
		
		Pageable pageable= PageRequest.of(pageNumber-1, 3);//pageNumber starts from 0
		
		Page<Employee> all = employeeRepository.findAll(pageable);
		
		List<Employee> employees = all.toList();
		
		return employees;
	}
	
	
	//sorting
}
