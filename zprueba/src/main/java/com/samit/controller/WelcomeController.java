package com.samit.controller;

import com.google.gson.Gson;
import com.samit.model.Schedule;
import com.samit.model.User;
import com.samit.service.ScheduleService;
import com.samit.utils.SimpleJson;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
    public String addSchedule(HttpServletRequest request, HttpSession session, Model model) {

        String dateString = request.getParameter("scheduleDate");
    	User userForm = (User) session.getAttribute("userForm");
    	SimpleJson result = new SimpleJson();
    	
		if (userForm != null) {
		    Schedule schedule = new Schedule();
	        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        if(dateString == null || dateString.isEmpty()) {
		        result.put("noDate", "Please select a date to schedule");
	        }else {
		        try {
					Date date = formatter.parse(dateString);
					schedule.setDate(date);
			        schedule.setUser(userForm);
			        scheduleService.add(schedule);
			        
			        result.put("worked", "Success");
		        } catch (ParseException e) {
					// TODO Auto-generated catch block
	
		        	result.put("failed", "Failed");
					e.printStackTrace();
				}
	        }
	        
		}
		
        return result.toJson();
    }
    
    @ResponseBody
    @RequestMapping(value = "/showSchedule", method = RequestMethod.GET)
    public String showSchedule(HttpSession session, Model model) {
    	User userForm = (User) session.getAttribute("userForm");
    	List<Schedule> schedules = scheduleService.getAllByUser(userForm);
    	SimpleJson simpleJson = new SimpleJson();
    	Gson gson = new Gson();
    	simpleJson.put("schedules", gson.toJson(schedulesToDateList(schedules)));
    	return simpleJson.toJson();
    }
    
    public ArrayList<Date> schedulesToDateList(List<Schedule> schedules){
    	ArrayList<Date> dates = new ArrayList<>();
    	for(Schedule schedule : schedules) {
    		dates.add(schedule.getDate());
    	}
    	return dates;
    }
}
