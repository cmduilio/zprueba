package com.samit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.samit.model.Role;

@Repository
public class RoleDao implements Dao<Role> {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleDao.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void add(Role p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Role saved successfully, Role Details="+p);
	}

	public void update(Role p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Role updated successfully, Role Details="+p);
	}

	@SuppressWarnings("unchecked")
	public List<Role> getList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Role> rolesList = session.createQuery("from Role").list();
		for(Role p : rolesList){
			logger.info("Role List::"+p);
		}
		return rolesList;
	}

	public Role getById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Role p = (Role) session.load(Role.class, id);
		logger.info("Role loaded successfully, Role details="+p);
		return p;
	}

	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role p = (Role) session.load(Role.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Role deleted successfully, Role details="+p);
	}
}

