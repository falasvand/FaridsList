package com.spring.form.web.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="users")
public class User implements Serializable{
	
	private static final long serialVersionUID = 4032366347627072533L;
	
	@NotBlank
	@Size(min=5, max=15)
	@Pattern(regexp="^\\w{5,}$")
	@Id
	private String username;
	@NotBlank
	@Pattern(regexp="^\\S+$")
	@Size(min=7, max=15)
	private String password;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@Size(min=3, max=60)
	private String name;
	private boolean enabled = false;
	private String authority;

	public User() {
	}

	public User(String username, String name, String password, String email, boolean enabled, String authority) {
		this.username = username;
		this.name = name;
		this.password = password;
		this.email = email;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
