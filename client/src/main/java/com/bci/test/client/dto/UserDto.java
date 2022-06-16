package com.bci.test.client.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserDto {

	private String name;
	
	private String email;
	
	private String password;
	
	private List<PhoneDto> phones;
	
}
