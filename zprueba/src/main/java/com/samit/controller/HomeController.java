package com.samit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home() {
//		return "home";
//	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("name", "PEPEEEEEEEEEEE");
		return "home";
	}
}
