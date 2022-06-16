package com.bci.test.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bci.test.client.dto.UserDto;
import com.bci.test.client.entity.User;
import com.bci.test.client.service.UserService;

@RestController
public class UserController extends ResponseEntityExceptionHandler{

	@Autowired
	private UserService userService; 
	
	@PostMapping(path = "/public/insertUser")
	@ExceptionHandler(Error.class)
	public ResponseEntity<?> insertANewUser(@RequestBody UserDto userDto)
	{
		User insertarNuevoUsuario = userService.insertarNuevoUsuario(userDto);
		if(insertarNuevoUsuario!=null) {
			return ResponseEntity.ok(insertarNuevoUsuario);
		}
			
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
	}
	
	@GetMapping(path = "/public/findById/{id}")
	@ExceptionHandler(Error.class)
	public ResponseEntity<?> getAUserById(@PathVariable int id)
	{
		return ResponseEntity.ok(userService.findById(id));
	}
}
