package com.ty;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MsgController {

	// designing methods which takes requests and produces response(Model and View)

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

	@GetMapping(value = "/read")
	public ModelAndView read(HttpServletRequest request) {

		String name = request.getParameter("un");
		String email = request.getParameter("ue");

		System.out.println("Name : " + name);
		System.out.println("Email : " + email);
		
		ModelAndView mv=new ModelAndView("test.jsp");
		mv.addObject("name", name);
		mv.addObject("email", email);

		return mv;
	}

	// passing data from controller to view.
	@GetMapping("/pass")
	public String passData(Model model) {

		model.addAttribute("id", 101);
		model.addAttribute("name", "Dinga");

		return "display.jsp";
	}

	@GetMapping("/data")
	public ModelAndView sendData() {

		ModelAndView mv = new ModelAndView("data.jsp");
//		mv.setViewName("data.jsp");
		mv.addObject("id", 102);
		mv.addObject("name", "Manga");

		return mv;
	}

}
