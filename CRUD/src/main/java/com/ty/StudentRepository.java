package com.ty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

	//custom methods : to design custom methods we need follow naming conventions for method
	
	public List<Student> findByName(String name);
	
	List<Student> findByStd(String std);
	
	List<Student> findByNameAndStd(String name, String std);
	
}
