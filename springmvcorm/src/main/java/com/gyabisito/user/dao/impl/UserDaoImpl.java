package com.gyabisito.user.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.gyabisito.user.dao.UserDao;
import com.gyabisito.user.entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int create(User user) {
		em.persist(user);
		return user.getId();
	}

	@Override
	public List<User> findUsers() {
		return em.createQuery("from User", User.class).getResultList();
	}

	@Override
	public User findUser(Integer id) {
		return em.find(User.class, id);
	}
}
