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

import com.samit.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void add(User p) {
		entityManager.persist(p);
		logger.info("User saved successfully, User Details=" + p);
	}

	public void update(User p) {

		entityManager.merge(p);
		logger.info("User updated successfully, User Details=" + p);
	}

	@SuppressWarnings("unchecked")
	public List<User> getList() {
		List<User> usersList = entityManager.createQuery("from User").getResultList();
		for (User p : usersList) {
			logger.info("User List::" + p);
		}
		return usersList;
	}

	public User getById(Long id) {
		User p = (User) entityManager.find(User.class, id);
		logger.info("User loaded successfully, User details=" + p);
		return p;
	}

	public void remove(int id) {
		User p = (User) entityManager.find(User.class, new Integer(id));
		if (null != p) {
			entityManager.remove(p);
		}
		logger.info("User deleted successfully, User details=" + p);
	}

	public User getByUsername(String username) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> root = criteria.from(User.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		predicates.add(cb.equal(root.get("username"), username));
		criteria.where(predicates.toArray(new Predicate[predicates.size()])).distinct(true);
		
		User user = (User) entityManager.createQuery(criteria)
				.getSingleResult();
		logger.info("User ::" + user);
		return user;
	}

}
