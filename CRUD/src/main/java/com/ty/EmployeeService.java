package com.ty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	// save employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	// pagination
	public List<Employee> pagination(int pageNumber) {

		Pageable pageable = PageRequest.of(pageNumber - 1, 3);// pageNumber starts from 0

		Page<Employee> all = employeeRepository.findAll(pageable);

		List<Employee> employees = all.toList();

		return employees;
	}

	// sorting
	public List<Employee> sort(String param) {

		List<Employee> employees = employeeRepository.findAll(Sort.by(param).ascending());

		return employees;
	}

	// Query by Example --> It is used for filtering the records, i.e whenever the conditions can vary(number of 
	// conditions are not fixed) then we make use of query by Example.
	public List<Employee> filter(Employee employee) {
		
		Example<Employee> of = Example.of(employee);
		
		List<Employee> all = employeeRepository.findAll(of);
		
		return all;
	}

}
