package com.blogs.customexceptions;

public class InvalidCredentialsException extends RuntimeException {
	public InvalidCredentialsException(String mesg) {
		super(mesg);
	}

}
