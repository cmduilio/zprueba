package com.samit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Error404Controller {

	@RequestMapping(value = { "/404" }, method = RequestMethod.GET)
	public static String error404(Model model) {
		return "redirect:/404";
	}
	
}
