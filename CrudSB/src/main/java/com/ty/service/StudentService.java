package com.ty.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.entity.Student;
import com.ty.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;

	public Student save(Student student) {
		return studentRepo.save(student);
	}

	public Student getById(Integer sid) {
		Student student = studentRepo.findById(sid).orElseThrow(() -> new RuntimeException("Student Not Found"));
		return student;
	}

	public Student update(Integer sid, Student student) {
		Optional<Student> opt = studentRepo.findById(sid);
		if (opt.isPresent()) {
			student.setSid(sid);
			return studentRepo.save(student);
		}
		return null;
	}

	public String deleteStudent(Integer sid) {
		Optional<Student> opt = studentRepo.findById(sid);
		if (opt.isPresent()) {
			studentRepo.deleteById(sid);
			return "Delete succ";
		} else {
			return "Student Not Found";
		}
	}
}
