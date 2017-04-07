package com.spring.form.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.spring.form.web.dao.Message;
import com.spring.form.web.dao.MessagesDao;
import com.spring.form.web.dao.User;
import com.spring.form.web.dao.UserDao;

@Service("userService")
public class UserService {

	@Autowired
	private UserDao udao;
	@Autowired
	private MessagesDao mdao;

	public void create(User u) {
		udao.create(u);
	}

	public boolean exists(String username) {
		return udao.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return udao.getAllUsers();
	}
	
	public void sendMessage(Message message){
		mdao.saveOrUpdate(message);
	}
	
	public User getUser(String username){
		return udao.getUser(username);
	}

	public List<Message> getMessages(String username) {
		return mdao.getMessages(username);
	}
}
