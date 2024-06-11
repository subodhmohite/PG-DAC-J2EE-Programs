package com.app.dao;

import com.app.entities.User;

public interface UserDao {
//add a method for user's signin
	User signIn(String email, String password);

	/*
	 * // add a method for voter reg. String voterRegistration(User newVoter);
	 * 
	 * // update password String changePassword(String email, String oldPwd, String
	 * newPwd);
	 * 
	 * // delete voter details String deleteVoterDetails(int voterId);
	 * 
	 * // add a method to update voting status String updateVotingStatus(int
	 * voterId);
	 */
}
