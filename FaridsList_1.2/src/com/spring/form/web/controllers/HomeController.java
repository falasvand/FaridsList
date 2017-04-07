package com.spring.form.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.form.web.dao.Comment;
import com.spring.form.web.service.CommentService;

@Controller
public class HomeController {
	
	@Autowired
	private CommentService cs;
	
	@RequestMapping("/")
	public String showHome(Model model, Principal principal){
		
		List<Comment> comments = cs.getCurrent();
		
		model.addAttribute("comments", comments);
		
		boolean hasComment = false;
		
		if(principal != null){
			hasComment = cs.hasComment(principal.getName());
		}
		
		model.addAttribute("hasComment", hasComment);
		
		return "home";
	}
	
}
