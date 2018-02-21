package com.samit.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.samit.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
	private static final Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);
	
	@Autowired
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void add(Role p) {
		entityManager.persist(p);
		logger.info("Role saved successfully, Role Details="+p);
	}

	public void update(Role p) {
		entityManager.merge(p);
		logger.info("Role updated successfully, Role Details="+p);
	}

	@SuppressWarnings("unchecked")
	public List<Role> getList() {
		List<Role> rolesList =  entityManager.createQuery("from Role").getResultList();
		for(Role p : rolesList){
			logger.info("Role List::"+p);
		}
		return rolesList;
	}

	public Role getById(Long id) {
		Role p = (Role) entityManager.find(Role.class, id);
		logger.info("Role loaded successfully, Role details="+p);
		return p;
	}

	public void remove(int id) {
		Role p = (Role) entityManager.find(Role.class, new Integer(id));
		if(null != p){
			entityManager.remove(p);
		}
		logger.info("Role deleted successfully, Role details="+p);
	}
}

