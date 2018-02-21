package com.samit.service;

import java.util.List;

import com.samit.model.Schedule;
import com.samit.model.User;

public interface ScheduleService extends Service<Schedule> {

	public List<Schedule> getAllByUser(User user);
}
