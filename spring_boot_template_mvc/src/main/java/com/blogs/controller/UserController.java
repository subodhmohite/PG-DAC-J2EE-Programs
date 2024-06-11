package com.blogs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.blogs.entities.Role;
import com.blogs.entities.User;
import com.blogs.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	//add a method for processing login form
	@PostMapping("/login")
	/*
	 * @RequestParam:method argument level annotation
	 * to bind request parameters to method args
	 * Done auto By SC
	 * should match request parameters names to method arguments names
	 */
	public String processLoginForm(@RequestParam String email,@RequestParam String password,
			Model map,HttpSession session) {
		System.out.println("in procesLoginform "+getClass());
		try {
		//invoke service layer method 
		User user = userService.signInUser(email, password);
		//login succesfull 
		//add user details n message ---under model attribute 
		
		session.setAttribute("message", "Login Successfull");
		session.setAttribute("user_deatils",user);
		
		map.addAttribute("message","Login Successfull")
		.addAttribute("user_deatils",user);
		//check the role--in case of admin --forward the client to admin homepage
		if(user.getRole()==Role.ADMIN)
			return "redirect:/admin/home";
		/*
		 * SC--- redirect+URL encoding
		 * Next URL -- http://localhost:8080/spring_boot/admin/home
		 */
		//o.w--check the role--in case of blogger --forward the client to blooging homepage
		System.out.println(user);
		return "redirect:/blogger/home";
		/*
		 * SC--- redirect+URL encoding
		 * Next URL -- http://localhost:8080/spring_boot/blogger/home
		 */
		}catch(RuntimeException e) {
			System.out.println("err "+e);
			//invalid login,forward the client to the login form
			//highlighted with errors
			map.addAttribute("message",e.getMessage());

		}
		return "/users/login";//AVN :/WEB-INF/views/users/login
	}
	

}
