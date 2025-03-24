package com.ty.cp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.cp.entity.Enquiry;
import java.util.List;
import com.ty.cp.enums.Course;
import com.ty.cp.enums.Status;



public interface EnquriyRepo extends JpaRepository<Enquiry, Integer>{

	List<Enquiry> findByCourse(Course course);
	
	List<Enquiry> findByStatus(Status status);
}
