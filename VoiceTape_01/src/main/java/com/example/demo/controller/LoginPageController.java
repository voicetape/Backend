package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.UserMapper;
import com.example.demo.dto.Config.SessionUser;


@RestController
public class LoginPageController {
	
	private final HttpSession httpSession = null;
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/login_sample")
	public String session_user(Model model) {
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		System.out.println("SESSION USER :: "+user);
		if (user!=null) {
			model.addAttribute("userName", user.getName());
		}
		return "login";
	}
	
	
	//@GetMapping("/oauth") // redirect_uri : /oauth
	//public String redirect_uri(@RequestParam("code"))
}
