package com.samit.controller;

import com.samit.model.User;
import com.samit.service.UserService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, HttpSession session) {
		if (userForm != null && userForm.getUsername() != null && !userForm.getUsername().equals("")
				&& userForm.getPassword() != null && !userForm.getPassword().equals("")
				&& userForm.getPasswordConfirm() != null && !userForm.getPasswordConfirm().equals("")
				&& userForm.getPassword().equals(userForm.getPasswordConfirm())) {

			userService.add(userForm);
			session.setAttribute("userForm", userForm);
			return "redirect:/welcome";
		} else {
			return "registration";
		}

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		User userForm = (User) session.getAttribute("userForm");

		if (userForm != null && userForm.getUsername() != null && !userForm.getUsername().equals("")) {
			return "redirect:/welcome";
		}

		model.addAttribute("userForm", new User());

		return "login";
	}

	// Acá tenia un redirectAttributes para pasar info de una dirección a otra
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userForm") User userForm, Model model, HttpSession session) {
		try {
			User user = userService.getByUsername(userForm.getUsername());
			if (user != null) {
				session.setAttribute("userForm", userForm);
			}
		} catch (Exception ex) {
			model.addAttribute("error", "Your username and password is invalid.");
			return login(model, session);
		}

		return "redirect:/welcome";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(HttpSession session) {
		String redirect;
		User userForm = (User) session.getAttribute("userForm");

		if (userForm != null && userForm.getUsername() != null && !userForm.getUsername().equals("")) {
			redirect = "welcome";
		} else {
			redirect = error404(null);
		}
		return redirect;
	}

	@RequestMapping(value = { "/404" }, method = RequestMethod.GET)
	public String error404(Model model) {
		return "404";
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		model.addAttribute("userForm", null);
		session.setAttribute("userForm", null);
		return login(model, session);
	}
}
