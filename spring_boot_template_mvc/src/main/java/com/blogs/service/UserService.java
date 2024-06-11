package com.blogs.service;

import com.blogs.entities.User;

public interface UserService {
	//add a method for user's sign in
	User signInUser(String email,String pwd);
	

}
