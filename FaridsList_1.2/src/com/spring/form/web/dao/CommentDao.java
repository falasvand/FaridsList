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
@Component("commentsDao")
public class CommentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getComments() {

		Criteria crit = session().createCriteria(Comment.class);
		crit.createAlias("user", "u").add(Restrictions.eq("u.enabled", true));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Comment> getComments(String username) {

		Criteria crit = session().createCriteria(Comment.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.eq("u.username", username));
		return crit.list();
	}
	
	public void saveOrUpdate(Comment c) {
		session().saveOrUpdate(c);
	}
	
	public void delete(int id) {
		
		Query q = session().createQuery("delete from Comment where id=:id");
		q.setLong("id", id);
		q.executeUpdate();
	}

	public Comment getComment(int id) {

		Criteria crit = session().createCriteria(Comment.class);
		crit.createAlias("user", "u");
		crit.add(Restrictions.eq("u.enabled", true));
		crit.add(Restrictions.idEq(id));
		return (Comment) crit.uniqueResult();
	}
	
}
