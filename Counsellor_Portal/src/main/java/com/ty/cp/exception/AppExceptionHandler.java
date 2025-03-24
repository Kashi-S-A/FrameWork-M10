package com.ty.cp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(CounsellorNotFound.class)
	public ResponseEntity<String> catchCounsellorNotFound(CounsellorNotFound exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EnquiryNotFound.class)
	public ResponseEntity<String> catchEnquiryNotFound(EnquiryNotFound exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> catchException() {
		return new ResponseEntity<String>("Something went wrong please try again later", HttpStatus.BAD_REQUEST);
	}
}
