package com.ty;

import java.util.List;

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
//		List<Student> students = studentRepo.findAll();
//		System.out.println(students);
		
//		delete record.
//		studentRepo.deleteById(1L);
//		System.out.println("deleted");
		
//		Optional<Student> opt = studentRepo.findById(14L);
		
//		if (opt.isPresent()) {
//			Student student = opt.get();
//			System.out.println(student);
//		}else {
//			throw new RuntimeException("Not found");
//		}
		
//		Student student = opt.orElseThrow(()-> new RuntimeException("Not found"));
//		System.out.println(student);
		
//		List<Student> students = studentRepo.getByName("Dinga");
//		System.out.println(students);
		
//		List<Student> students = studentRepo.getByNameStd("Dingi xyz", "12th");
//		System.out.println(students);
		
//		List<Student> students = studentRepo.findByName("Dinga");
//		System.out.println(students);
		
//		List<Student> byNameAndStd = studentRepo.findByNameAndStd("Dinga", "12th");
//		System.out.println(byNameAndStd);
		
		EmployeeService service = run.getBean(EmployeeService.class);
		
//		Employee employee=new Employee();
//		employee.setName("C");
//		employee.setEmail("c@gmail.com");
//		employee.setSalary(18000.0);
//		
//		service.save(employee);
//		System.out.println("saved");
		
//		List<Employee> emps = service.pagination(4);// i need to start it from page 1.
//		
//		System.out.println("-----------Emps----------");
//		for (Employee employee : emps) {
//			System.out.println("Eid : "+employee.getEid());
//			System.out.println("Name : "+employee.getName());
//			System.out.println("Email : "+employee.getEmail());
//			System.out.println("Salary : "+employee.getSalary());
//			System.out.println("==========================");
//		}
		
//		List<Employee> employees = service.sort("name");
//		
//		System.out.println("-----------Emps----------");
//		for (Employee employee : employees) {
//			System.out.println("Eid : "+employee.getEid());
//			System.out.println("Name : "+employee.getName());
//			System.out.println("Email : "+employee.getEmail());
//			System.out.println("Salary : "+employee.getSalary());
//			System.out.println("==========================");
//		}
		
		
		Employee emp=new Employee();
//		emp.setName("C");
//		emp.setEmail("c@gmail.com");
		emp.setSalary(10000.0);
		
		List<Employee> employees = service.filter(emp);
		
		System.out.println("-----------Emps----------");
		for (Employee employee : employees) {
			System.out.println("Eid : "+employee.getEid());
			System.out.println("Name : "+employee.getName());
			System.out.println("Email : "+employee.getEmail());
			System.out.println("Salary : "+employee.getSalary());
			System.out.println("==========================");
		}
	}

}
