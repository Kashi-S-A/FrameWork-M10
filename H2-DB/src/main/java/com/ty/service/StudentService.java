package com.ty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Student;
import com.ty.exception.StudentNotFound;
import com.ty.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo repo;

	public Student save(Student student) {
		Student savedStu = repo.save(student);
		return savedStu;
	}

	public Student findBySid(Integer sid) {
		Student student = repo.findById(sid).orElseThrow(() -> new StudentNotFound("Student Is Not Registered"));
		return student;
	}

	
}
