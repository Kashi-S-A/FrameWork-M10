package com.ty;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CrudApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CrudApplication.class, args);

		StudentRepository studentRepo = run.getBean(StudentRepository.class);

//		Save record.
//		Student student = new Student();
//		student.setSid(4L);
//		student.setName("Dinga manga XYZ");
//		student.setPhone(87654567l);
//		student.setStd("12th");
//		
//		Student save = studentRepo.save(student);
//		
//		System.out.println(save);
		
//		Fetch all records.
//		Iterable<Student> students = studentRepo.findAll();
//		System.out.println(students);
		
//		delete record.
//		studentRepo.deleteById(1L);
//		System.out.println("deleted");
		
		Optional<Student> opt = studentRepo.findById(14L);
		
//		if (opt.isPresent()) {
//			Student student = opt.get();
//			System.out.println(student);
//		}else {
//			throw new RuntimeException("Not found");
//		}
		
		Student student = opt.orElseThrow(()-> new RuntimeException("Not found"));
		System.out.println(student);

	}

}
