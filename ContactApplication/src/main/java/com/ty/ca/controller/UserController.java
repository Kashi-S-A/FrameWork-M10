package com.ty.ca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.ca.entity.Contact;
import com.ty.ca.entity.User;
import com.ty.ca.service.ContactService;
import com.ty.ca.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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

		boolean login = userService.login(email, password);

		ModelAndView mv = new ModelAndView();

		if (login) {
			mv.setViewName("home.jsp");
			mv.addObject("msg", "Welcome to Contact App");

			User user = userService.getUserByEmail(email);
			List<Contact> contacts = user.getContacts();

			mv.addObject("contacts", contacts);

			HttpSession session = request.getSession(true);// true ==> create new Session object if it is not exists
															// else it will return existing session object.
															// false ==> returns only existing session, if not exists it
															// returns null.
			session.setAttribute("uid", user.getUid());

		} else {
			mv.setViewName("login.jsp");
			mv.addObject("msg", "Invalid credentials");
		}

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView addPage() {

		ModelAndView mv = new ModelAndView("add.jsp");

		mv.addObject("contact", new Contact());

		return mv;
	}

	@PostMapping("/add")
	public ModelAndView addContact(Contact contact, HttpServletRequest request) {

		HttpSession session = request.getSession(false);

		Integer uid = (Integer) session.getAttribute("uid");

		User user = userService.getById(uid);

		contact.setUser(user);

		boolean result = contactService.saveContact(contact);

		ModelAndView mv = new ModelAndView("home.jsp");

		mv.addObject("contacts", user.getContacts());

		if (result) {
			mv.addObject("msg", "Contact added successfully");
		} else {
			mv.addObject("msg", "Failed to add contact");
		}

		return mv;
	}

	@GetMapping("/update")
	public ModelAndView updatePage(@RequestParam String cid) {

		Integer contactId = Integer.parseInt(cid);

		Contact contact = contactService.findById(contactId);

		ModelAndView mv = new ModelAndView("update.jsp");
		mv.addObject("contact", contact);

		return mv;
	}

	@PostMapping("/update")
	public ModelAndView updateContact(Contact contact) {

		Contact dbContact = contactService.findById(contact.getCid());

		dbContact.setName(contact.getName());
		dbContact.setAdharNo(contact.getAdharNo());
		dbContact.setPhone(contact.getPhone());

		boolean result = contactService.saveContact(dbContact);

		ModelAndView mv = new ModelAndView("home.jsp");

		mv.addObject("contacts", dbContact.getUser().getContacts());

		if (result) {
			mv.addObject("msg", "Contact updated successfully");
		} else {
			mv.addObject("msg", "Failed to update contact");
		}

		return mv;
	}

}
