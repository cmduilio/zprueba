package com.samit.controller;

import com.samit.model.Role;
import com.samit.model.User;
import com.samit.service.UserService;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		String redirect;
		
		if (userRegistrationValidate(userForm)) {
			
			Role role = new Role();
			role.setId(1L);
			Set<Role> roles = new HashSet<Role>();
			roles.add(role);
			userForm.setRoles(roles);
			
			userService.add(userForm);
			session.setAttribute("userForm", userForm);
			redirect = "redirect:/welcome";
		} else {
			redirect = "registration";
		}
		
		return redirect;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {
		String redirect;
		
		User userForm = (User) session.getAttribute("userForm");

		if (userForm != null && userForm.getUsername() != null && !userForm.getUsername().equals("")) {
			redirect = "redirect:/welcome";
		}else {
			model.addAttribute("userForm", new User());
			redirect = "login";
		}

		return redirect;
	}

	// Acá tenia un redirectAttributes para pasar info de una dirección a otra
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("userForm") User userForm, Model model, HttpSession session) {
		String redirect;
		
		try {
			User user = userService.getByUsername(userForm.getUsername());
			if (userLoginUserValidate(user, userForm)) {
				session.setAttribute("userForm", userForm);
			}
			
			redirect = "redirect:/welcome";
		} catch (Exception ex) {
			model.addAttribute("error", "Your username and password is invalid.");
			redirect = login(model, session);
		}

		return redirect;
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public String welcome(HttpSession session) {
		return redirectIfLogedIn(session, "welcome");
	}

	@RequestMapping(value = { "/404" }, method = RequestMethod.GET)
	public String error404(Model model) {
		return "404";
	}
	
	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public String profile(HttpSession session) {
		return redirectIfLogedIn(session, "profile");
	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		model.addAttribute("userForm", null);
		session.setAttribute("userForm", null);
		return login(model, session);
	}
	
	private String redirectIfLogedIn(HttpSession session, String redirect) {
		User userForm = (User) session.getAttribute("userForm");

		if (userForm == null) {
			redirect = error404(null);
		}
		return redirect;
	}

	private boolean userRegistrationValidate(User userForm) {
		return userForm != null && userForm.getUsername() != null && !userForm.getUsername().isEmpty()
				&& userForm.getPassword() != null && !userForm.getPassword().isEmpty()
				&& userForm.getPasswordConfirm() != null && !userForm.getPasswordConfirm().isEmpty()
				&& userForm.getPassword().equals(userForm.getPasswordConfirm());
	}
	

	private boolean userLoginUserValidate(User user, User userForm) {
		return user != null && user.getUsername() != null && !user.getUsername().isEmpty()
				&& user.getPassword() != null && !user.getPassword().isEmpty() 
				&& userForm != null && userForm.getUsername() != null && !userForm.getUsername().isEmpty()
				&& userForm.getPassword() != null && !userForm.getPassword().isEmpty()
				&& user.getUsername().equals(userForm.getUsername())
				&& user.getPassword().equals(userForm.getPassword());
	}

}
