package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//spring bean containing request handling logic 
public class UserHomeController {
	public UserHomeController() {
		System.out.println("in constructor of "+getClass());
	}
	//add a method to render th login page
	@GetMapping("/")
	public String showLoginForm() {
		System.out.println("in showLoginForm "+getClass());
		return "/users/login";//Handler return LVN to DS to VR returns AVN
		//AVN--> /WEB-INF/views/users/login.jsp
	}

}
