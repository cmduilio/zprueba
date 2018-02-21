package com.samit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samit.dao.ScheduleDao;
import com.samit.dao.ScheduleDaoImpl;
import com.samit.model.Schedule;
import com.samit.model.User;

@Service
public class ScheduleServiceImpl implements ScheduleService{
	
	@Autowired
	private ScheduleDao scheduleDao;

	public void setScheduleDao(ScheduleDaoImpl scheduleDao) {
		this.scheduleDao = scheduleDao;
	}

	@Transactional
	public void add(Schedule p) {
		this.scheduleDao.add(p);
	}

	@Transactional
	public void update(Schedule p) {
		this.scheduleDao.update(p);
	}

	@Transactional
	public List<Schedule> getList() {
		return this.scheduleDao.getList();
	}

	@Transactional
	public Schedule getById(Long id) {
		return this.scheduleDao.getById(id);
	}

	@Transactional
	public void remove(int id) {
		this.scheduleDao.remove(id);
	}
	
	@Transactional
	public List<Schedule> getAllByUser(User user) {
		return this.scheduleDao.getAllByUser(user);
	}
	
}
