package com.spring.form.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("userDao")
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void create(User u) {
		session().save(u);		
	}

	public boolean exists(String username) {
		User user = getUser(username);
		return user != null;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		return session().createQuery("from User").list();
	}

	public User getUser(String username) {
		Criteria crit = session().createCriteria(User.class);
		crit.add(Restrictions.eq("username", username));
		return (User) crit.uniqueResult();
	}

	public void disableUser(String username) {
		User user = session().get(User.class, username);
		user.setEnabled(false);
	}

	public void enableuser(String username) {
		User user = session().get(User.class, username);
		user.setEnabled(true);
	}
}
