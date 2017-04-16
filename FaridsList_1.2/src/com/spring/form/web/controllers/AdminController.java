package com.spring.form.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.form.web.dao.User;
import com.spring.form.web.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/admin")
	public String showAdmin(Model model){

		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "admin";
	}
	
	@RequestMapping(value="/enableuser", method=RequestMethod.POST)
	public String ennableUser(@RequestParam("username") String username){
		
		userService.enableUser(username);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/disableuser", method=RequestMethod.POST)
	public String disableUser(@RequestParam("username") String username){
		
		userService.disableUser(username);
		return "redirect:/admin";
	}
}
