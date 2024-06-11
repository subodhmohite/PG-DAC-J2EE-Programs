package com.blogs.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//mandatory class level annotation to tell Spring container following is req handling spring bean
//singleton and eager
public class TestController {
	public TestController() {
		System.out.println("in constructor of"+" "+getClass());
	}
	//add init method 
	@PostConstruct
	public void myInit() {
		System.out.println("in init of"+getClass());
	}
	
	//add a request handling to forward the client to the view layer display a welcome mesg
	@RequestMapping("/test1")
	public String testMe() {
		System.out.println("in tesMe");
		return "/display";//LVN,handler return LogicalViewName to dispatcher Servlet
		//View Resolver bean returns AVN=prefix+LVN+suffix
		// AVN=> /WEB-INF/views/display.jsp
	}

}
