package com.samit.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController extends com.samit.controller.Controller{
	
	@RequestMapping(value = { "/profile" }, method = RequestMethod.GET)
	public static String profile(HttpSession session) {
		return redirectIfLogedIn(session, "profile");
	}

}
