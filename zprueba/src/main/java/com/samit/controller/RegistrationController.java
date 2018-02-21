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
public class RegistrationController extends com.samit.controller.Controller{

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
	private boolean userRegistrationValidate(User userForm) {
		return userForm != null && userForm.getUsername() != null && !userForm.getUsername().isEmpty()
				&& userForm.getPassword() != null && !userForm.getPassword().isEmpty()
				&& userForm.getPasswordConfirm() != null && !userForm.getPasswordConfirm().isEmpty()
				&& userForm.getPassword().equals(userForm.getPasswordConfirm());
	}
}
