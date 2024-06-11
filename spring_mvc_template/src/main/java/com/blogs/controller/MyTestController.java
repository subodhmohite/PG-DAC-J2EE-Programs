package com.blogs.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//base pattern of the incoming url-pattern,
//can be supplied at the class level --optional but recom.
@RequestMapping("/test")
public class MyTestController {
	public MyTestController() {
		System.out.println("in contr of"+getClass());
	}
	//add req handling method to display server side time stamp 
	//i.e. a Dynamic resp
	@GetMapping("/test2")//@RequestMapping(method=Get)
	public  ModelAndView renderDynResult() {
		System.out.println("in render Dynamic res");
		/*
		 * o.s.web.servlet.ModelAndView:Class that holds LVN + results
		 * Result are represented by model attributes
		 * (name, value pair)
		 * Constructor-
		 * ModelAndView(String LVN, String modelAttriName, Oject modelAttrValue)
		 * 
		 */
		return new ModelAndView("/test/display","server_ts",LocalDateTime.now());
	/*
	 * Handler returns a ModelAndView object to DispatcherServlet
	 * DS sends LVN--> ViewResolver --> AVN(/WEB-INF/views/test/display.jsp)--> DS
	 * DS--> adds model attributes under requestScope
	 * Ds forwards the client 
	 */
	}
	
	

}
