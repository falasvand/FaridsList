package com.spring.form.web.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.form.web.dao.Comment;
import com.spring.form.web.service.CommentService;

@Controller
public class FormController {

	private CommentService cs;
	
	@Autowired
	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	
	@RequestMapping("/createcomment")
	public String createComment(Model model, Principal principal){
		
		Comment comment = null;
		
		if(principal != null){
			String username = principal.getName();
			comment = cs.getCurrent(username);
		}
		
		if(comment == null){
			comment = new Comment();
		}
		
		model.addAttribute("comment", comment);
		return "createcomment";
	}
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Comment comment, BindingResult result, 
			Principal principal, @RequestParam(value="delete", required=false) String delete){

		if(result.hasErrors()){
			return "createcomment";
		}
		
		if(delete == null){
			String username = principal.getName();
			comment.getUser().setUsername(username);
			cs.saveOrUpdate(comment);
			return "commentcreated";
		}else{
			cs.delete(comment.getId());
			return "commentdeleted";
		}
		
	}
}
