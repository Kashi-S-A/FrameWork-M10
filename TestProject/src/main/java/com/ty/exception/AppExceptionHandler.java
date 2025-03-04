package com.ty.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView catchArithmeticException(ArithmeticException exception) {
		
		ModelAndView mv=new ModelAndView("exc.jsp");
		mv.addObject("errmsg", exception.getMessage());
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public String catchException() {
		return "handle.jsp";
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public String catchUserNotFoundException() {
		return "userError.jsp";
	}
}
