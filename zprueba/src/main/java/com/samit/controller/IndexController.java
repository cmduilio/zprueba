package com.samit.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController extends com.samit.controller.Controller{

	@RequestMapping(value = {"/", "/index" }, method = RequestMethod.GET)
	public String index(HttpSession session) {
		return "index";
	}
}
