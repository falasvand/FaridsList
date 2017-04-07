package com.spring.form.web.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.form.web.dao.Message;
import com.spring.form.web.dao.User;
import com.spring.form.web.service.UserService;

@Controller
public class LoginController {

	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/login")
	public String showLogin(){
		return "login";
	}
	
	@RequestMapping("/denied")
	public String showDenied(){
		return "denied";
	}
	
	@RequestMapping("/messages")
	public String showMessages(){
		return "messages";
	}
	
	@RequestMapping("/loggedout")
	public String showLogout(){
		return "loggedout";
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model){

		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "admin";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model m){
		m.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result){

		if(result.hasErrors()){
			return "newaccount";
		}
		
		user.setAuthority("ROLE_USER");
		user.setEnabled(true);
		
		if(userService.exists(user.getUsername())){
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}else{
			userService.create(user);
		}
		
		return "accountcreated";
	}
	
	@RequestMapping(value="/getmessages", method=RequestMethod.GET, produces="application/json")
	@ResponseBody
	public Map<String, Object> getMessages(Principal p){
		
		List<Message> messages = null;
		if(p == null){
			messages = new ArrayList<Message>();
		}else{
			String username = p.getName();
			messages = userService.getMessages(username);
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("messages", messages);
		data.put("number", messages.size());
		
		return data;
	}
	
	@RequestMapping(value="/sendmessage", method=RequestMethod.POST, produces="application/json")
	@ResponseBody
	public Map<String, Object> sendMessage(Principal p, @RequestBody Map<String, Object> data){
		
		String text = (String) data.get("text");
		String name = (String) data.get("name");
		String email = (String) data.get("email");
		Integer target = (Integer) data.get("target");
		
		System.out.println(name + " : " + email + " : " + text);
		
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("success", true);
		returnValue.put("target", target);
		return returnValue;
	}
}



