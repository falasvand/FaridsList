package com.spring.form.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.spring.form.web.dao.Comment;
import com.spring.form.web.dao.CommentDao;

@Service("commentService")
public class CommentService {

	private CommentDao cdao;
	
	@Autowired
	public void setCdao(CommentDao cdao) {
		this.cdao = cdao;
	}

	public List<Comment> getCurrent(){
		return cdao.getComments();
	}

	@Secured({"ROLE_USER","ROLE_ADMIN"})
	public void create(Comment c) {
		cdao.saveOrUpdate(c);
	}

	public boolean hasComment(String name) {

		if(name == null){
			return false;
		}
		
		List<Comment> comments = cdao.getComments(name);
		
		if(comments.size() == 0){
			return false;
		}
		
		return true;
	}

	public Comment getCurrent(String username) {
		
		if(username == null){
			return null;
		}

		List<Comment> comments = cdao.getComments(username);
		
		if(comments.size() == 0){
			return null;
		}
		
		return comments.get(0);
	}

	public void saveOrUpdate(Comment comment) {
			cdao.saveOrUpdate(comment);
	}

	public void delete(int id) {
		cdao.delete(id);
		
	}
	
}
