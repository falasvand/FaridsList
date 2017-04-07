package com.spring.form.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CommentRowMapper implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {

		User u = new User();
		u.setAuthority(rs.getString("authority"));
		u.setEmail(rs.getString("email"));
		u.setEnabled(true);
		u.setName(rs.getString("name"));
		u.setUsername(rs.getString("username"));
		
		Comment c = new Comment();
		c.setId(rs.getInt("id"));
		c.setText(rs.getString("text"));
		c.setUser(u);

		return c;
	}

}
