package com.wxine.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.wxine.domain.User;

@Component
@Transactional
public class UserDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Session getSession() {
		return entityManager.unwrap(Session.class);
	}
	
	public void save(User user){
		getSession().save(user);
	}
	public Query Login(String sql){
		return getSession().createQuery("FROM Register as u WHERE u.account=? AND u.password=?");
		
	}
	
}
