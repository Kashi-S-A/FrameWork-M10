package com.ty.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;

	@Size(min = 3, max = 10,message = "For name characters should be between 3 and 10")
	private String name;

	@Email(message = "please enter the valid email id")
	private String email;

	@NotNull
	private Long phone;

}
