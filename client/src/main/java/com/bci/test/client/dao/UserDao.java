package com.bci.test.client.dao;

import java.util.Date;

import com.bci.test.client.entity.User;

import lombok.Data;

@Data
public class UserDao {

	private Integer id;
	
	private Date created;
	
	private Date modified;
	
	private Date lastLoginDate;
	
	private String token;
	
	private String isactive;
	
	public UserDao(User user){
		this.id = user.getId();
		this.created = user.getCreatedDate();
		this.modified = user.getModifiedDate();
		this.lastLoginDate = user.getLastLoginDate();
		this.token = "token";
		this.isactive = user.getIsactiveStatus();
	}
}
