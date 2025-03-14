package com.ty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MsgController {

	//designing methods which takes requests and produces response(Model and View)

	@RequestMapping("/msg")
	public String msg() {
		System.out.println("Msg api is triggered");
		return "index.jsp";
	}
	
//	@RequestMapping(value = "/greet",method = RequestMethod.GET)
	
	@GetMapping("/greet")
	public String greet() {
		return "greet.jsp";
	}
	
	@PostMapping("/test")
	public String postApi() {
		return "";
	}
	
	
	
	//it is supporting for get request
	//it is supporting for post request
	@RequestMapping(value = "/read")
	public String read(HttpServletRequest request) {
		
		String name = request.getParameter("un");
		String email = request.getParameter("ue");
		
		System.out.println("Name : "+name);
		System.out.println("Email : "+email);
		
		return "";
	}
}
