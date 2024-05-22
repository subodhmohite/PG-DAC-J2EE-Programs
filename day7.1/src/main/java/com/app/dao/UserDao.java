package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Role;
import com.app.entities.User;



public interface UserDao {
//add a method for user sign up
	String registerUser(User user);
	//add a method to get user details by it's id
	User getUserDetails(Long userId);
	//add a method to return list of all users
	List<User> getAllUsers();
	//add a method to return list of users by date of birth n role
	List<User> getUsersByDobAndRole(LocalDate start,LocalDate end1,Role role);

}
