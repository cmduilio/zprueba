package com.samit.controller;

import javax.servlet.http.HttpSession;

import com.samit.model.User;

public class Controller {
	public static String redirectIfLogedIn(HttpSession session, String redirect) {
		User userForm = (User) session.getAttribute("userForm");

		if (userForm == null) {
			redirect = Error404Controller.error404(null);
		}
		return redirect;
	}	
}
