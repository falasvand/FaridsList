package com.spring.form.web.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="comments")
public class Comment {

	@Id
	@GeneratedValue
	private int id;
	@Size(min=10, max=250)
	private String text;
	@ManyToOne
	@JoinColumn(name="username")
	private User user;

	public Comment() {
		this.user = new User();
	}

	public Comment(User user, String text) {
		this.user = user;
		this.text = text;
	}

	public Comment(int id, User user, String text) {
		this.id = id;
		this.user = user;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUsername(){
		return user.getUsername();
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", user=" + user + "]";
	}


}
