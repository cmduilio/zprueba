package com.samit.dao;

 import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.samit.model.Schedule;
import com.samit.model.User;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

	private static final Logger logger = LoggerFactory.getLogger(ScheduleDaoImpl.class);

	@Autowired
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void add(Schedule p) {
		entityManager.persist(p);
		logger.info("Schedule saved successfully, Schedule Details=" + p);
	}

	public void update(Schedule p) {

		entityManager.merge(p);
		logger.info("Schedule updated successfully, Schedule Details=" + p);
	}

	@SuppressWarnings("unchecked")
	public List<Schedule> getList() {
		List<Schedule> scheduleList = entityManager.createQuery("from Schedule").getResultList();
		for (Schedule p : scheduleList) {
			logger.info("Schedule List::" + p);
		}
		return scheduleList;
	}

	public Schedule getById(Long id) {
		Schedule p = (Schedule) entityManager.find(Schedule.class, id);
		logger.info("Schedule loaded successfully, User details=" + p);
		return p;
	}

	public void remove(int id) {
		Schedule p = (Schedule) entityManager.find(Schedule.class, new Integer(id));
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("Schedule deleted successfully, Schedule details=" + p);
	}
	
	public List<Schedule> getAllByUser(User user) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Schedule> criteria = cb.createQuery(Schedule.class);
		Root<Schedule> root = criteria.from(Schedule.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(cb.equal(root.get("user"), user));
		criteria.where(predicates.toArray(new Predicate[predicates.size()])).distinct(true);
		
		List<Schedule> schedules = entityManager.createQuery(criteria)
				.getResultList();
		logger.info("Schedules ::" + schedules);
		return schedules;
	}
}
