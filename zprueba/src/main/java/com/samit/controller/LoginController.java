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

@Controller
public class LoginController extends com.samit.controller.Controller{

	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public static String login(Model model,HttpSession session) {
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
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String login(@ModelAttribute("userForm") User userForm, Model model, HttpSession session) {
		String redirect;
		
		try {
			User user = userService.getByUsername(userForm.getUsername());
			if (userLoginUserValidate(user, userForm)) {
				session.setAttribute("userForm", user);
			}
			
			redirect = "redirect:/welcome";
		} catch (Exception ex) {
			model.addAttribute("error", "Your username and password is invalid.");
			redirect = login(model, session);
		}

		return redirect;
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
