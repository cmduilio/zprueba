package com.samit.dao;

import java.util.List;

import com.samit.model.Schedule;
import com.samit.model.User;

public interface ScheduleDao extends Dao<Schedule> {

	public List<Schedule> getAllByUser(User user);
}
