package com.ty.exception;

public class StudentNotFound extends RuntimeException {

	private String msg; 
	
	public StudentNotFound() {

	}

	public StudentNotFound(String msg) {
		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		return msg;
	}
}
