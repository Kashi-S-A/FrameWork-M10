package com.ty.ca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.ca.entity.Contact;
import com.ty.ca.entity.User;
import com.ty.ca.service.ContactService;
import com.ty.ca.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String indexPage(Model model) {

		model.addAttribute("user", new User());

		return "index.jsp";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login.jsp";
	}

	@PostMapping("/save")
	public ModelAndView register(User user) {

		boolean save = userService.save(user);

		ModelAndView mv = new ModelAndView("login.jsp");

		if (save) {
			mv.addObject("msg", "Registered Successfully");
		} else {
			mv.addObject("msg", "Already Registered");
		}

		return mv;
	}

	@PostMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean login = userService.login(email,password);
		
		ModelAndView mv = new ModelAndView();
		
		if (login) {
			mv.setViewName("home.jsp");
			mv.addObject("msg", "Welcome to Contact App");
			
			User user = userService.getUserByEmail(email);
			List<Contact> contacts = user.getContacts();
			
			mv.addObject("contacts", contacts);
			
		}else {
			mv.setViewName("login.jsp");
			mv.addObject("msg", "Invalid credentials");
		}
		
		return mv;
	}

}
