package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	public HomeController() {
		
			System.out.println("in constructor of"+" "+getClass());
	}
		
		
		//add a request handling to forward the client to the view layer display a welcome mesg
		@RequestMapping("/")
		public String home() {
			System.out.println("in home");
			return "/index";//LVN,handler return LogicalViewName to dispatcher Servlet
			//View Resolver bean returns AVN=prefix+LVN+suffix
			// AVN=> /WEB-INF/views/display.jsp
		

	}

}
