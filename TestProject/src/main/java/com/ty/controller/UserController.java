package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ty.entity.User;
import com.ty.service.UserService;

import jakarta.servlet.http.HttpServletRequest;



@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String registere() {
		
		return "index.jsp";
	}
	
	@PostMapping("/register")
	public String register(HttpServletRequest request,Model model) {
		String name = request.getParameter("un");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String password = request.getParameter("pwd");
		
		Long ph = Long.parseLong(phone);
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(ph);
		
		int a=10/0;
		
		boolean isReg = userService.saveUser(user);
		
		if (isReg) {
			model.addAttribute("msg", "Registered Succ");
		}else {
			model.addAttribute("msg", "Already Regi");
		}
		
		return "login.jsp";
	}
	
	
}
