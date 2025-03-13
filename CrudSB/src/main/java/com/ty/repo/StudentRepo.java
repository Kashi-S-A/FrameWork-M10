package com.ty.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
