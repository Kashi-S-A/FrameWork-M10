package com.ty.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.entity.Employee;

public interface EmpRepo extends JpaRepository<Employee	, Integer>{

}
