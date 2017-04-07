package com.spring.form.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
@Component("messagesDao")
public class MessagesDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Message> getMessages() {
		Criteria crit = session().createCriteria(Message.class);
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> getMessages(String username) {

		Criteria crit = session().createCriteria(Message.class);
	
		crit.add(Restrictions.eq("username", username));
		return crit.list();
	}
	
	public void saveOrUpdate(Message m) {
		session().saveOrUpdate(m);
	}
	
	public void delete(int id) {
		
		Query q = session().createQuery("delete from Message where id=:id");
		q.setLong("id", id);
		q.executeUpdate();
	}

	public Message getMessage(int id) {

		Criteria crit = session().createCriteria(Message.class);
	
		crit.add(Restrictions.idEq(id));
		return (Message) crit.uniqueResult();
	}
	
}
