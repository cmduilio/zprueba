package com.samit.controller;

import com.samit.model.Schedule;
import com.samit.model.User;
import com.samit.service.ScheduleService;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController extends com.samit.controller.Controller{

	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(value = {"/welcome" }, method = RequestMethod.GET)
	public String welcome(HttpSession session) {
		return redirectIfLogedIn(session, "welcome");
	}
	
	@RequestMapping(value = { "/logout" }, method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.setAttribute("userForm", null);
		return LoginController.login(model, session);
	}

    @ResponseBody
    @RequestMapping(value = "/addSchedule", method = RequestMethod.GET)
    public String addSchedule(HttpSession session, Model model) {
    	User userForm = (User) session.getAttribute("userForm");
    	String result = "";
    	
		if (userForm == null) {
			result = Error404Controller.error404(null);
		}else {
	        Schedule schedule = new Schedule();
	        Date date = new Date();
	        schedule.setDate(date);
	        schedule.setUser(userForm);
	        scheduleService.add(schedule);
	        
	        model.addAttribute("toast", "funcionó");
		}
		
        return result;
    }
    
    @ResponseBody
    @RequestMapping(value = "/showSchedule", method = RequestMethod.GET)
    public String showSchedule(HttpSession session, Model model) {
    	User userForm = (User) session.getAttribute("userForm");
    	List<Schedule> schedules = scheduleService.getAllByUser(userForm);
    	model.addAttribute("schedules", schedules);
    	return "";
    }
}
