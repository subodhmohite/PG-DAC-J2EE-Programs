package com.blogs.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRespDTO extends BaseDTO{
	private String firstname;
	private String lastname;
	private LocalDate dob;
	private String phoneNo;

}
