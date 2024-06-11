package com.blogs.dto;

import java.time.LocalDateTime;

public class ApiResponse {
	private String message;
	private LocalDateTime timeStamp;
	
	
	public ApiResponse() {
		
	}
	public ApiResponse(String message) {
		super();
		this.message=message;
		this.timeStamp=LocalDateTime.now();
	}
	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", timeStamp=" + timeStamp + "]";
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

}
